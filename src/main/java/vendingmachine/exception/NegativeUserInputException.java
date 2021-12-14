package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class NegativeUserInputException extends IllegalArgumentException {
	public NegativeUserInputException() {
		super(NEGATIVE_USER_INPUT_EXCEPTION_MESSAGE);
		System.out.println(NEGATIVE_USER_INPUT_EXCEPTION_MESSAGE);
	}
}
