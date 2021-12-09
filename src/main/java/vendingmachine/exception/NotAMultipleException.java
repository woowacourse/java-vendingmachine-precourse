package vendingmachine.exception;

public class NotAMultipleException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE = "입력은 %d의 배수여야 합니다.";

	public NotAMultipleException(int multiple) {
		super(String.format(ERROR_MESSAGE, multiple));
	}
}
