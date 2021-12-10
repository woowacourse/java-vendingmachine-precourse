package vendingmachine.exception;

public class NotFoundCoinException extends IllegalArgumentException {
	public NotFoundCoinException() {
		super("코인을 찾을수 없습니다.");
	}
}
