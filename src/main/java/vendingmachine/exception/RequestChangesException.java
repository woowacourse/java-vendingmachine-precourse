package vendingmachine.exception;

/**
 * 잔돈 반환 요구가 들어왔을 때 발생시키는 예외
 */
public class RequestChangesException extends RuntimeException {
	public RequestChangesException() {
		super();
	}
}
