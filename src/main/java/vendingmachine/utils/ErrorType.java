package vendingmachine.utils;

public enum ErrorType {
	ERROR_HEADER("[ERROR]"),
	ERROR_MONEY_IS_NOT_NUMBER(ERROR_HEADER.text + "금액은 숫자여야 합니다."),
	ERROR_MONEY_NOT_DIVIDED_BY_TEN(ERROR_HEADER.text + "금액은 10원으로 나누어 떨어져야 합니다."),
	ERROR_MONEY_IS_ZERO(ERROR_HEADER.text + "금액은 0이 아니어야 합니다."),
	ERROR_MONEY_IS_BLANK(ERROR_HEADER.text + "빈값이 아닌 금액을 입력하셔야 합니다.")
	;

	private final String text;

	ErrorType(final String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}


}
