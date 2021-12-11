package vendingmachine.exception;

public class NotGreaterThanOrEqualsException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE = "상품의 가격은 %d 이상이어야 합니다.";

	public NotGreaterThanOrEqualsException(int threshold) {
		super(String.format(ERROR_MESSAGE, threshold));
	}
}
