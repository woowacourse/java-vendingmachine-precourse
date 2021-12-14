package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class PriceNotMultipleOfTenMessageException extends VendingMachineException {

	public PriceNotMultipleOfTenMessageException() {
		super(ErrorMessage.PRICE_NOT_MULTIPLE_OF_TEN_MESSAGE);
	}

}
