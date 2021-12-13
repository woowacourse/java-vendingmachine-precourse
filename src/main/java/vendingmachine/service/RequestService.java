package vendingmachine.service;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.utils.validator.RequestValidator;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.InputView;

public class RequestService {
	public static Changes toChanges(String request) throws IllegalArgumentException {
		RequestValidator.isEmpty(request);
		RequestValidator.isNumber(request);
		return new Changes(new Money(Integer.parseUnsignedInt(request)));
	}
}
