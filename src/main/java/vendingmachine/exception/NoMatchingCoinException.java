package vendingmachine.exception;

public class NoMatchingCoinException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "입력된 액수의 동전이 존재하지 않습니다.";

	public NoMatchingCoinException() {
		super(ERROR_MESSAGE);
	}
}
