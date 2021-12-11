package vendingmachine.exception;

import static vendingmachine.config.ConstantConfig.*;

public class ProductInputFormatException extends CustomException {

	public ProductInputFormatException() {
		getMessage(PRODUCT_INPUT_FORMAT_EXCEPTION);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
