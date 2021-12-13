package vendingmachine.service;

import vendingmachine.domain.Changes;
import vendingmachine.utils.validator.RequestValidator;

public class ChangesService {
	public static Changes toChanges(String request) throws IllegalArgumentException {
		RequestValidator.isEmpty(request);
		Changes changes = new Changes();
		changes.setRandomChanges(MoneyService.toMoney(request));
		return changes;
	}
}
