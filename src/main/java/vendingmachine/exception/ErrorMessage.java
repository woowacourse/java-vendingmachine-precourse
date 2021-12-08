package vendingmachine.exception;

public enum ErrorMessage {

	PRICE_IS_NOT_NUMBER_ERROR("금액은 자연수여야 합니다.");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
