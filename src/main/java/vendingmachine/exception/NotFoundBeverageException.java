package vendingmachine.exception;

public class NotFoundBeverageException extends IllegalArgumentException {
	public NotFoundBeverageException() {
		super("해당 상품을 찾을수 없습니다.\n");
	}
}
