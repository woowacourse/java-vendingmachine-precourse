package vendingmachine.service;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.utils.validator.RequestValidator;

public class ChangesService {
	public static Changes toChanges(String request) throws IllegalArgumentException {
		RequestValidator.isEmpty(request);
		RequestValidator.isNumber(request);
		Changes changes = new Changes();
		changes.setRandomChanges(new Money(Integer.parseUnsignedInt(request)));
		return changes;
	}
}
