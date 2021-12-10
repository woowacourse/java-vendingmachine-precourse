package vendingmachine.exception;

public class ItemInputFormatException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "상품 입력 형식이 올바르지 않습니다.";

	public ItemInputFormatException() {
		super(ERROR_MESSAGE);
	}
}
