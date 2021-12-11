package vendingmachine.exception;

import static vendingmachine.config.ConstantConfig.*;

public class AmountIsNotRangedException extends CustomException {
	public AmountIsNotRangedException() {
		getMessage(AMOUNT_IS_NOT_RANGED_EXCEPTION_MESSAGE);
	}

	@Override public void getMessage(String message) {
		System.out.println(message);
	}
}
