package vendingmachine.exception;

public class ItemEmptyException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "하나 이상의 상품을 입력해야합니다.";

	public ItemEmptyException() {
		super(ERROR_MESSAGE);
	}
}
