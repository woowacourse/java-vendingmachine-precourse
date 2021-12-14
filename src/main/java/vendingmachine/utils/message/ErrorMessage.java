package vendingmachine.utils.message;

public enum ErrorMessage {
	ERROR_HEADER("[ERROR] "),
	ERROR_MONEY_IS_NOT_NUMBER(ERROR_HEADER.text + "금액은 숫자여야 합니다."),
	ERROR_MONEY_NOT_DIVIDED_BY_TEN(ERROR_HEADER.text + "금액은 10원으로 나누어 떨어져야 합니다."),
	ERROR_MONEY_IS_ZERO(ERROR_HEADER.text + "금액은 0이 아니어야 합니다."),
	ERROR_MONEY_IS_BLANK(ERROR_HEADER.text + "빈값이 아닌 금액을 입력하셔야 합니다."),

	ERROR_PRODUCT_INFO_IS_NOT_VALID(
		ERROR_HEADER.text + "잘못된 형식입니다. " + "\n상품명, 가격, 수량은 쉼표(,)로 개별 상품은 대괄호([])로 묶고 세미콜론(;)으로 구분하여 입력해야 합니다."
			+ "\n입력 예시) [콜라,1500,20];[사이다,1000,10]"),

	ERROR_PRODUCT_NAME_DUPLICATED(ERROR_HEADER.text + "서로 다른 상품명을 입력해야 합니다."),
	ERROR_PRODUCT_DOES_NOT_EXIST(ERROR_HEADER.text + "자판기에 없는 상품입니다. 다른 상품을 입력해주세요."),
	ERROR_PRODUCT_OUT_OF_STOCK(ERROR_HEADER.text + "상품 재고가 없습니다. 다른 상품을 입력해주세요."),
	ERROR_CANNOT_BUY_PRODUCT_WITH_CURRENT_MONEY(ERROR_HEADER.text + "현재 가지고 있는 돈이 부족하여 구매할 수 없습니다. 다른 상품을 입력해주세요."),
	;

	private final String text;

	ErrorMessage(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
