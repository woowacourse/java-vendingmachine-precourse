package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	NO_SUCH_AMOUNT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "없는 동전 종류입니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}
