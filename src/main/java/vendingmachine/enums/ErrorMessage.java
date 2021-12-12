package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	NO_SUCH_AMOUNT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "없는 동전 종류입니다."),
	NO_SAME_NAME_PRODUCT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "같은 이름을 가진 상품이 없습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}
