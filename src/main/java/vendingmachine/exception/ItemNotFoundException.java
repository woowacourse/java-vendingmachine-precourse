package vendingmachine.exception;

public class ItemNotFoundException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "입력한 상품명을 가진 상품이 존재하지 않습니다.";

	public ItemNotFoundException() {
		super(ERROR_MESSAGE);
	}
}
