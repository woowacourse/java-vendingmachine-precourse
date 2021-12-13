package vendingmachine.constant;

public class ErrorMessage {
	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INPUT_PREFIX = "입력값이 ";
	public static final String ERROR_NOT_NUMBER = ERROR_PREFIX + INPUT_PREFIX + "숫자이어야 합니다.";
	public static final String ERROR_NOT_POSITIVE = ERROR_PREFIX + INPUT_PREFIX + "양수이어야 합니다.";
	public static final String ERROR_NOT_CORRECT_UNIT = ERROR_PREFIX + INPUT_PREFIX + "10으로 나누어 떨어져야 합니다.";
}
