package vendingmachine.util;

public final class Constants {
	public static final String INPUT_MESSAGE_VENDING_MACHINE_PRICE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_MESSAGE_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";

	public static final String OUTPUT_MESSAGE_COINS = "자판기가 보유한 동전";

	public static final String ERROR_MESSAGE = "[ERROR] ";
	public static final String ERROR_MESSAGE_INPUT_VENDING_MACHINE_PRICE =
		ERROR_MESSAGE + "금액은 10원 이상이며, 10원으로 나누어떨어지는 숫자여야 합니다.";
	public static final String ERROR_MESSAGE_INPUT_PRODUCT =
		ERROR_MESSAGE + "상품명, 가격(숫자), 수량(숫자)은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 합니다. "
			+ "ex) [콜라,1500,20];[사이다,1000,10]";

	public static final int VENDING_MACHINE_PRICE_MIN_VALUE = 10;
	public static final int VENDING_MACHINE_PRICE_DENOMINATOR = 10;

	public static final String PRODUCT_SEPARATOR = ";";
	public static final String PRODUCT_INFO_SEPARATOR = ",";

	public static final int PRODUCT_INFOS_SIZE = 3;
	public static final int PRODUCT_PRICE_MIN_VALUE = 100;
	public static final int PRODUCT_PRICE_DENOMINATOR = 10;
	public static final int PRODUCT_COUNT_MIN_VALUE = 1;
}
