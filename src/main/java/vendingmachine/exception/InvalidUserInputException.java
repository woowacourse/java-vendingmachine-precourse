package vendingmachine.exception;

import static vendingmachine.constant.ExceptionConstant.*;

public class InvalidUserInputException extends IllegalArgumentException {
	public InvalidUserInputException() {
		super(ILLEGAL_USER_INPUT_EXCEPTION_MESSAGE);
		System.out.println(ILLEGAL_USER_INPUT_EXCEPTION_MESSAGE);
	}
}
