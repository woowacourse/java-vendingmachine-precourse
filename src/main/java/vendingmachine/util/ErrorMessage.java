package vendingmachine.util;

public enum ErrorMessage {
	ERROR("[ERROR]"),
	NOT_NUMBER_ERROR("숫자를 입력해야 합니다."),
	NOT_MINUS_NUMBER("양수인 숫자를 입력해야 합니다,"),
	NOT_DIVIDED_BY_TEN("10원 단위의 돈을 입력해야 합니다"),
	INVALID_ITEM_INFO_FORMAT("[item,price,count] 형식으로 입력해야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
