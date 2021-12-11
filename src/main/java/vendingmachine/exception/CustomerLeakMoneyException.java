package vendingmachine.exception;

import static vendingmachine.config.ConstantConfig.*;

public class CustomerLeakMoneyException extends CustomException {

	public CustomerLeakMoneyException() {
		getMessage(CUSTOMER_LEAK_MONEY_EXCEPTION_MESSAGE);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
