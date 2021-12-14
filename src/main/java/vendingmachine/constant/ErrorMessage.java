package vendingmachine.constant;

public class ErrorMessage {
	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INPUT_PREFIX = "입력값이 ";
	public static final String ERROR_NOT_NUMBER = ERROR_PREFIX + INPUT_PREFIX + "숫자이어야 합니다.";
	public static final String ERROR_NOT_POSITIVE = ERROR_PREFIX + INPUT_PREFIX + "양수이어야 합니다.";
	public static final String ERROR_NOT_CORRECT_UNIT = ERROR_PREFIX + INPUT_PREFIX + "10으로 나누어 떨어져야 합니다.";
	public static final String ERROR_INVALID_BRACKETS = ERROR_PREFIX + "자판기 입력값은 '['로 시작하여 ']'로 끝나야 합니다.";
	public static final String ERROR_INVALID_ITEM_FORMAT = ERROR_PREFIX + "자판기 항목은 [이름,가격,수량]으로 입력해야 합니다.";
	public static final String ERROR_NON_EXISTS_ITEM = ERROR_PREFIX + "존재하지 않는 상품입니다.";
}
