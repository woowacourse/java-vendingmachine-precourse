package vendingmachine.exception;

public class NotGreaterThanOrEqualsException extends IllegalArgumentException {
	// TODO: 무슨 입력인지 알 수 있도록 메세지를 개선할 필요있음
	public static final String ERROR_MESSAGE = "입력은 %d 이상이어야 합니다.";

	public NotGreaterThanOrEqualsException(int threshold) {
		super(String.format(ERROR_MESSAGE, threshold));
	}
}
