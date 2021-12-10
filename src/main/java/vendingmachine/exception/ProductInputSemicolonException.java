package vendingmachine.exception;

import static vendingmachine.utils.Constant.*;

public class ProductInputSemicolonException extends CustomException {

	public ProductInputSemicolonException() {
		getMessage(PRODUCT_INPUT_SEMICOLON_EXCEPTION_MESSAGE);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
