package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class MoneyNotMultipleOfTenMessageException extends VendingMachineException {

	public MoneyNotMultipleOfTenMessageException() {
		super(ErrorMessage.MONEY_NOT_MULTIPLE_OF_TEN_MESSAGE);
	}

}
