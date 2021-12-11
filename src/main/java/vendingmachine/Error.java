package vendingmachine;

public class Error {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static final String ONLY_NUMBER = "금액은 숫자여야 합니다.";
	public static final String OVER_ZERO = "금액은 0이상의 숫자여야 합니다.";
	public static final String DIVIDED_BY_TEN = "금액은 10원 단위로 입력해야 합니다.";

	public static void error(String str) {
		throw new IllegalArgumentException(ERROR_PREFIX + str);
	}
}
