package vendingmachine;

public enum Error {
	NOT_NUMBER_INITIAL_MONEY("[ERROR] 보유 금액은 숫자여야 합니다."),
	NOT_MULTIPLE_OF_TEN_INITIAL_MONEY("[ERROR] 보유 금액은 10의 배수여야 합니다."),
	NOT_EQUAL_OR_GREATER_THAN_TEN_INITIAL_MONEY("[ERROR] 보유 금액은 10원 이상이여야 합니다."),
	NOT_NUMBER_PRODUCT_NUMBER("[ERROR] 상품 갯수는 숫자여야 합니다."),
	NOT_MORE_THAN_ONE_PRODUCT_NUMBER("[ERROR] 상품 갯수는 1개 이상이어야 합니다."),
	NOT_NUMBER_PRODUCT_PRICE("[ERROR] 상품 가격은 숫자여야 합니다."),
	NOT_MULTIPLE_OF_TEN_PRODUCT_PRICE("[ERROR] 상품 가격은 10의 배수여야 합니다."),
	NOT_MORE_THAN_A_HUNDRED_WON_PRODUCT_PRICE("[ERROR} 상품 가격은 100원 이상이여야 합니다."),
	NOT_MATCHED_BRACKET_PRODUCT_ENTRY("[ERROR] 개별 상품은 대괄호([])로 묶여야 합니다."),
	ILLEGAL_CHARS_OUTSIDE_BRACKETS_PRODUCT_ENTRY("[ERROR] 대괄호([])쌍 사이에는 세미콜론(;) 혹은 공백만이 입력되어야 합니다."),
	ILLEGAL_NUMBER_OF_ELEMENTS_PRODUCT_ENTRY("[ERROR] 개별 상품은 [상품명, 가격, 수량] 3가지의 입력이여야 합니다."),
	ILLEGAL_LENGTH_OF_PRODUCT_NAME("[ERROR] 상품명은 1자 이상이어야 합니다."),
	NO_ENTRY_SEPARATOR("[ERROR] 개별 상품은 세미콜론(;)으로 구분해야 합니다."),
	NOT_NUMBER_USER_MONEY("[ERROR] 투입 금액은 숫자여야 합니다."),
	NOT_MULTIPLE_OF_TEN_USER_MONEY("[ERROR] 투입 금액은 10의 배수여야 합니다."),
	NOT_EQUAL_OR_GREATER_THAN_TEN_USER_MONEY("[ERROR] 투입 금액은 10원 이상이여야 합니다.");

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
