package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class NotEnoughMoneyException extends IllegalArgumentException {
	public NotEnoughMoneyException() {
		super(NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE);
		System.out.println(NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE);
	}
}
