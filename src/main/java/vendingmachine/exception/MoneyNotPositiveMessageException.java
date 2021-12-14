package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class MoneyNotPositiveMessageException extends VendingMachineException {

	public MoneyNotPositiveMessageException() {
		super(ErrorMessage.MONEY_NOT_POSITIVE_MESSAGE);
	}

}
