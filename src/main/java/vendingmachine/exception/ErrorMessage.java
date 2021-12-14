package vendingmachine.exception;

public enum ErrorMessage {

	COST_IS_NOT_NUMBER_ERROR("금액은 자연수여야 합니다."),
	INPUT_IS_BLANK_ERROR("입력 값은 빈 값일 수 없습니다."),
	COST_IS_NOT_DIVIDE_TEN_ERROR("금액은 10으로 나누어 떨어져야 합니다."),
	PRODUCT_INPUT_FORMAT_ERROR("개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 함니다."),
	PRODUCT_INPUT_INFORMATION_ERROR("상품명, 가격, 수량은 쉼표로, 구분하여 상품명, 가격, 수량 3개의 정보가 입력되어야 합니다."),
	PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR("상품 가격은 100이상의 자연수 여야 합니다."),
	PRODUCT_PRICE_IS_NOT_DIVIDE_TEN_ERROR("상품 가격은 10으로 나누어 떨어져야 합니다."),
	PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR("상품 수량은 자연수여야 합니다."),
	PRODUCT_IS_DISTINCT_ERROR("상품은 중복돼서 들어올 수 없습니다."),
	PRODUCT_NAME_IS_NOT_IN_PRODUCTS("상품 목록에 없는 상품입니다."),
	PRODUCT_AMOUNT_IS_ZERO_ERROR("상품이 매진되었습니다.");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
