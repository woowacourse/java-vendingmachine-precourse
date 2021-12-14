package vendingmachine.utils;

public enum Messages {
	ERROR_NOT_POSITIVE("[ERROR] 가격이나 수량은 반드시 양수여야 합니다."),
	ERROR_NOT_NUMBER("[ERROR] 가격이나 수량은 반드시 숫자여야 합니다."),
	ERROR_NOT_VALID_NAME("[ERROR] 상품이름에는 공백 및 특수문자가 포함될 수 없습니다."),
	ERROR_NOT_VALID_ELEMENT_SIZE("[ERROR] 상품정보는 상품이름,상품가격,상품수량의 형식으로 총 3개여야 합니다."),
	ERROR_NOT_VALID_ITEM_SIZE("[ERROR] 전체 상품정보 중 유효하지 않은 상품이 있습니다."),
	ERROR_NOT_VALID_PARENTHESES("[ERROR] 상품정보는 한 쌍의 대괄호로 구분해야 합니다."),
	ERROR_BLANK("[ERROR] 입력은 반드시 한글자 이상이어야 합니다."),
	ERROR_NOT_CONTAIN_MESSAGE("[ERROR] 해당 상품은 존재하지 않습니다."),
	ERROR_DUPLICATE_NAME_INPUT("[ERROR] 상품 이름은 중복을 허용하지 않습니다."),
	ERROR_NOT_ENOUGH_MONEY_MESSAGE("[ERROR] 금액이 부족합니다."),
	ERROR_SOLD_OUT_MESSAGE("[ERROR] 해당 상품은 품절입니다."),
	ERROR_NOT_DIVIDABLE_MESSAGE("[ERROR] 금액의 최소 단위는 10원 입니다."),
	ERROR_NOT_OVER_MINIMUM_PRICE("[ERROR] 상품 금액은 100원 이상이어야 합니다."),
	COMMON_LINE_BREAK_MSG("\n"),
	OUTPUT_VIEW_NOTICE_COIN_INPUT_MSG("자판기가 보유하고 있는 금액을 입력해 주세요."),
	OUTPUT_VIEW_NOTICE_ITEM_INPUT_MSG("상품명과 가격, 수량을 입력해 주세요."),
	OUTPUT_VIEW_NOTICE_PAY_MONEY_INPUT_MSG("투입 금액을 입력해 주세요."),
	OUTPUT_VIEW_NOTICE_BUY_ITEM_INPUT_MSG("구매할 상품명을 입력해 주세요."),
	OUTPUT_VIEW_NOW_MONEY_MSG("투입 금액: "),
	OUTPUT_VIEW_WON_MSG("원"),
	OUTPUT_VIEW_COIN_COUNT_MSG("개"),
	OUTPUT_VIEW_DASH_MSG(" - "),
	OUTPUT_VIEW_RETURN_MONEY_MSG("잔돈"),
	OUTPUT_VIEW_INITIAL_COIN_MSG("자판기가 보유한 동전");

	private final String value;

	Messages(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
