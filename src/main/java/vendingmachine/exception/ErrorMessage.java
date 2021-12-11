package vendingmachine.exception;

public enum ErrorMessage {

	COST_IS_NOT_NUMBER_ERROR("금액은 자연수여야 합니다."),
	INPUT_IS_BLANK_ERROR("입력 값은 빈 값일 수 없습니다."),
	COST_IS_NOT_DIVIDE_TEN_ERROR("금액은 10으로 나누어 떨어져야 합니다."),
	PRODUCT_INPUT_FORMAT_ERROR("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 함니다.");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
