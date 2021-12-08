package vendingmachine;

public enum Notification {
	AMOUNT_CONVERT_FAILURE("[ERROR] 금액은 숫자여야 합니다."),
	AMOUNT_EXCEED_RANGE("[ERROR] 금액은 0이상의 정수여야 합니다."),
	AMOUNT_SMALLER_MINIMUM_UNIT("[ERROR] 금액이 최소 단위보다 커야합니다.");

	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
