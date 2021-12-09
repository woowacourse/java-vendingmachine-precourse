package vendingmachine.exception;

public class NotNaturalNumberException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE = "입력은 자연수여야 합니다.";

	public NotNaturalNumberException() {
		super(ERROR_MESSAGE);
	}
}
