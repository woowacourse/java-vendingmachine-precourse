package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class PriceNotMoreThanMinimumAmountMessageException extends VendingMachineException {

	public PriceNotMoreThanMinimumAmountMessageException() {
		super(ErrorMessage.PRICE_NOT_MORE_THAN_MINIMUM_AMOUNT_MESSAGE);
	}

}
