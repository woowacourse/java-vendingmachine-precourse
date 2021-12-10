package vendingmachine.util;

public class SystemMessage {
	private static final String ERROR = "[ERROR]";

	public static final String INPUT_FIRST_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String ERROR_IS_NOT_INTEGER = ERROR + " 숫자를 입력해야 합니다.";
	public static final String ERROR_IS_NOT_POSITIVE = ERROR + " 양수를 입력해야 합니다.";
	public static final String ERROR_IS_NOT_MULTIPLE_OF_10 = ERROR + " 10의 배수를 입력해야 합니다.";
	public static final String SHOW_FIRST_MONEY = "자판기가 보유한 동전";
	public static final String INPUT_ITEM_INFO = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ERROR_IS_NOT_WRAPPED = ERROR + " []로 상품을 감싸서 입력해야 합니다.";
	public static final String ERROR_ITEM_DELIMITER = ERROR + " 상품명, 가격, 수량을 ','로 구분해야 합니다.";
}
