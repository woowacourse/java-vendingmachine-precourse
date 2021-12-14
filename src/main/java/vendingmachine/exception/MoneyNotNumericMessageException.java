package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class MoneyNotNumericMessageException extends VendingMachineException {

	public MoneyNotNumericMessageException() {
		super(ErrorMessage.MONEY_NOT_NUMERIC_MESSAGE);
	}

}
