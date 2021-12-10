package vendingmachine.exception;

public class BlankStringException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "입력은 공백일 수 없습니다.";

	public BlankStringException() {
		super(ERROR_MESSAGE);
	}
}
