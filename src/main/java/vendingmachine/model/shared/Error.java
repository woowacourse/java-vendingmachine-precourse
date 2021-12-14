package vendingmachine.model.shared;

public enum Error {
	NOT_NUMBER("숫자로만 입력해야 합니다."),
	CAN_NOT_BE_DIVIDED_BY_10("금액은 10원 단위로 입력해야 합니다."),
	MINUS("음수는 입력할 수 없습니다."),
	ITEM_FORMAT("형식에 맞게 입력하세요([상품명,가격,수량];[]...)"),
	BLANK("상품명은 공백일 수 없습니다."),
	DUPLICATE_ITEM("상품명이 중복됩니다."),
	PRICE_RANGE("상품 가격은 100 이상이어야 합니다."),
	COUNT_RANGE("상품 수량은 1 이상이어야 합니다."),
	NO_SUCH_ITEM("존재하지 않거나 품절된 상품입니다.");

	private final String massage;

	Error(String massage) {
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}
}
