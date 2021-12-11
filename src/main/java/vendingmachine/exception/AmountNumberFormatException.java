package vendingmachine.exception;

import static vendingmachine.config.ConstantConfig.*;

public class AmountNumberFormatException extends CustomException {

	public AmountNumberFormatException() {
		getMessage(AMOUNT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
	}

	@Override public void getMessage(String message) {
		System.out.println(message);
	}
}
