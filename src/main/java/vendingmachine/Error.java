package vendingmachine;

public enum Error {
	NOT_NUMBER_INITIAL_MONEY("[ERROR] 보유 금액은 숫자여야 합니다."),
	NOT_MULTIPLE_OF_TEN_INITIAL_MONEY("[ERROR] 보유 금액은 10의 배수여야 합니다."),
	NOT_EQUAL_OR_GREATER_THAN_TEN_INITIAL_MONEY("[ERROR} 보유 금액은 10원 이상이여야 합니다.");

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
