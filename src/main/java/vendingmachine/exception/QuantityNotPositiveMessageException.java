package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class QuantityNotPositiveMessageException extends VendingMachineException {

	public QuantityNotPositiveMessageException() {
		super(ErrorMessage.QUANTITY_NOT_POSITIVE_MESSAGE);
	}

}
