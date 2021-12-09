package vendingmachine.exception;

public class NotNumericException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE = "입력은 올바른 숫자여야 합니다.";

	public NotNumericException() {
		super(ERROR_MESSAGE);
	}
}
