package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	PRODUCT_INVALID_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "상품은 [상품명,가격,수량]으로 입력해주세요."),
	PRODUCT_SOLD_OUT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "상품이 매진되었습니다."),
	MONEY_NOT_NUMBER_ERROR_MESSAGE(ERROR_MESSAGE.get() + "돈은 2147483647 이하의 숫자로 입력해주세요."),
	MONEY_LOWER_THEN_ZERO_ERROR_MESSAGE(ERROR_MESSAGE.get() + "0원 이상으로 입력해주세요."),
	MONEY_LOWER_THEN_PRICE_ERROR_MESSAGE(ERROR_MESSAGE.get() + "돈이 부족합니다."),
	MONEY_NOT_DIVISIBLE_BY_10_ERROR_MESSAGE(ERROR_MESSAGE.get() + "돈은 10원으로 나누어 떨어져야 합니다."),
	PRICE_LOWER_THEN_MINIMUM_PRICE_ERROR_MESSAGE(ERROR_MESSAGE.get() + "가격은 100원 이상으로 입력해주세요."),
	QUANTITY_NOT_NUMBER_ERROR_MESSAGE(ERROR_MESSAGE.get() + "수량은 2147483647 이하의 숫자로 입력해주세요."),
	QUANTITY_LOWER_THEN_ZERO_ERROR_MESSAGE(ERROR_MESSAGE.get() + "수량은 0개 이상으로 입력해주세요."),
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
