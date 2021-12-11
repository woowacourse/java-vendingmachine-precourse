package vendingmachine.exception;

import static vendingmachine.config.ConstantConfig.*;

public class ProductIsNotExistedException extends CustomException {

	public ProductIsNotExistedException() {
		getMessage(PRODUCT_IS_NOT_EXISTED_EXCEPTION_MESSAGE);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
