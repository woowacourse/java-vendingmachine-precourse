package vendingmachine;

public enum Notification {
	AMOUNT_CONVERT_FAILURE("[ERROR] 금액은 숫자여야 합니다."),
	AMOUNT_EXCEED_RANGE("[ERROR] 금액은 0이상의 정수여야 합니다."),
	AMOUNT_SMALLER_MINIMUM_UNIT("[ERROR] 금액이 최소 단위보다 커야합니다."),
	COIN_NOT_FOUND("[ERROR] 해당하는 금액의 코인이 존재하지 않습니다."),
	QUANTITY_INVALID_RANGE("[ERROR] 수량은 int 범위 내 양의 정수여야 합니다."),
	QUANTITY_EXCEED_RANGE("[ERROR] 수량은 범위를 초과할 수 없습니다."),
	PRODUCT_INVALID_COMPOSITION("[ERROR] 상품이 올바르게 구성되어있지 않습니다.");




	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
