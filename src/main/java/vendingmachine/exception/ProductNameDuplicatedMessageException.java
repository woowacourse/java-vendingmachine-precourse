package vendingmachine.exception;

import vendingmachine.view.output.message.ErrorMessage;

public class ProductNameDuplicatedMessageException extends VendingMachineException {

	public ProductNameDuplicatedMessageException() {
		super(ErrorMessage.PRODUCT_NAME_DUPLICATED_MESSAGE);
	}

}
