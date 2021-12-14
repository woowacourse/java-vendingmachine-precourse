package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class ProductSoldOutMessageException extends VendingMachineException {

	public ProductSoldOutMessageException() {
		super(ErrorMessage.PRODUCT_SOLD_OUT_MESSAGE);
	}

}
