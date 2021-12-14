package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class ProductNotFoundMessageException extends VendingMachineException {

	public ProductNotFoundMessageException() {
		super(ErrorMessage.PRODUCT_NOT_FOUNT_MESSAGE);
	}

}
