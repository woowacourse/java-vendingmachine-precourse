package vendingmachine.utils;

public class ExceptionMessage {
	public static String ERROR_MESSAGE = "[ERROR] ";
	public static String ERROR_INPUT_AMOUNT = ERROR_MESSAGE + "입력 값은 숫자이어야 합니다.";
	public static String ERROR_INSUFFICIENT_INPUT_AMOUNT = ERROR_MESSAGE + "남은 투입 금액 부족으로 구매할 수 없습니다.";
	public static String ERROR_OUT_OF_STOCK = ERROR_MESSAGE + "선택한 제품의 재고가 없습니다.";
	public static String ERROR_DO_NOT_HAVE_PRODUCT = ERROR_MESSAGE + "입력한 이름의 제품이 없습니다.";
	public static String ERROR_ONLY_CAN_INPUT_POSITIVE_MONEY = ERROR_MESSAGE + "금액은 양수여야 합니다.";
	public static String ERROR_NOT_CORRECT_REGEX_INPUT = ERROR_MESSAGE + "입력 값 형식이 올바르지 않습니다.";
	public static String ERROR_INPUT_HOLDING_AMOUNT_MONEY = ERROR_MESSAGE + "입력 값은 숫자이어야 합니다.";
}
