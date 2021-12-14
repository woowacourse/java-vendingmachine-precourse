package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class QuantityNotNumericMessageException extends VendingMachineException {

	public QuantityNotNumericMessageException() {
		super(ErrorMessage.QUANTITY_NOT_NUMERIC_MESSAGE);
	}

}
