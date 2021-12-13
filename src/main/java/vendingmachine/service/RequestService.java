package vendingmachine.service;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.utils.validator.RequestValidator;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.InputView;

public class RequestService {
	public static Changes requestChanges() {
		try {
			String request = InputView.requestChanges();
			RequestValidator.isEmpty(request);
			RequestValidator.isNumber(request);
			return new Changes(new Money(Integer.parseUnsignedInt(request)));
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			return requestChanges();
		}
	}
}
