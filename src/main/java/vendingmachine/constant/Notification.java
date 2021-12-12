package vendingmachine.constant;

public enum Notification {
	AMOUNT_CONVERT_FAILURE("[ERROR] 금액은 숫자여야 합니다."),
	AMOUNT_EXCEED_RANGE("[ERROR] 금액은 0이상의 정수여야 합니다."),
	AMOUNT_SMALLER_MINIMUM_UNIT("[ERROR] 금액이 최소 단위보다 커야합니다."),
	AMOUNT_NOT_EARN("[ERROR] 최대 금액을 초과한 돈을 소유할 수 없습니다."),
	AMOUNT_NOT_SPEND("[ERROR] 금액이 부족해 사용할 수 없습니다."),
	COIN_NOT_FOUND("[ERROR] 해당하는 금액의 코인이 존재하지 않습니다."),
	QUANTITY_INVALID_RANGE("[ERROR] 수량은 int 범위 내 양의 정수여야 합니다."),
	QUANTITY_EXCEED_RANGE("[ERROR] 수량은 범위를 초과할 수 없습니다."),
	PRODUCT_INVALID_COMPOSITION("[ERROR] 상품이 올바르게 구성되어있지 않습니다."),
	PRODUCT_NAME_INVALID("[ERROR] 상품명이 올바르지 않습니다."),
	PRODUCT_INSUFFICIENCY_PRICE("[ERROR] 상품의 금액은 최소 100원 이상이여야합니다."),
	PRODUCT_ALREADY_EXIST("[ERROR] 동일한 상품명이 존재합니다."),
	PRODUCT_NOT_FOUND("[ERROR] 해당 상품이 존재하지 않습니다."),
	PRODUCT_IS_NULL("[ERROR] 상품을 올바르게 입력해주세요."),
	PRODUCTS_SIZE_INSUFFICIENT("[ERROR] 상품은 최소 1개 이상 입력해야합니다."),
	PRODUCTS_STOCK_INSUFFICIENT("[ERROR] 상품의 재고가 부족합니다. 다른 상품을 구매해주세요."),
	VENDING_MACHINE_INITIALIZE_FAIL("[ERROR] 자동판매기에는 상품들과 잔돈들이 있어야합니다.");

	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
