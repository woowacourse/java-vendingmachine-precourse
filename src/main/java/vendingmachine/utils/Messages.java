package vendingmachine.utils;

public enum Messages {
	ERROR_NOT_POSITIVE("[ERROR] 가격이나 수량은 반드시 양수여야 합니다."),
	ERROR_NOT_NUMBER("[ERROR] 가격이나 수량은 반드시 숫자여야 합니다."),
	ERROR_NOT_VALID_NAME("[ERROR] 상품이름에는 공백 및 특수문자가 포함될 수 없습니다."),
	ERROR_NOT_VALID_ELEMENT_SIZE("[ERROR] 상품정보는 상품이름,상품가격,상품수량의 형식으로 총 3개여야 합니다."),
	ERROR_NOT_VALID_ITEM_SIZE("[ERROR] 전체 상품갯수는 하나 이상이어야 합니다."),
	ERROR_BLANK("[ERROR] 입력은 반드시 한글자 이상이어야 합니다."),
	ERROR_NOT_CONTAIN_MESSAGE("[ERROR] 해당 상품은 존재하지 않습니다."),
	ERROR_NOT_ENOUGH_MONEY_MESSAGE("[ERROR] 금액이 부족합니다."),
	ERROR_SOLD_OUT_MESSAGE("[ERROR] 해당 상품은 품절입니다."),
	ERROR_NOT_DIVIDABLE_MESSAGE("[ERROR] 금액의 최소 단위는 10원 입니다."),
	COMMON_LINE_BREAK_MSG("\n");

	private final String value;

	Messages(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
