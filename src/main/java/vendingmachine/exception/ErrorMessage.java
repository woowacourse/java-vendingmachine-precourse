package vendingmachine.exception;

public enum ErrorMessage {

	COST_IS_NOT_NUMBER_ERROR("금액은 자연수여야 합니다."),
	COST_IS_BLANK_ERROR("금액은 빈 값일 수 없습니다."),
	COST_IS_NOT_DIVIDE_TEN("금액은 10으로 나누어 떨어져야 합니다.");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
