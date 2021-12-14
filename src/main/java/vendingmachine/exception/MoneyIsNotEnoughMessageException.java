package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class MoneyIsNotEnoughMessageException extends VendingMachineException {

	public MoneyIsNotEnoughMessageException() {
		super(ErrorMessage.MONEY_IS_NOT_ENOUGH_MESSAGE);
	}

}
