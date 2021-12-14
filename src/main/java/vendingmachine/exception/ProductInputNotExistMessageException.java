package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class ProductInputNotExistMessageException extends VendingMachineException {

	public ProductInputNotExistMessageException() {
		super(ErrorMessage.PRODUCT_INPUT_NOT_EXIST_MESSAGE);
	}

}
