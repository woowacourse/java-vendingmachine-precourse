package constants;

public class VendingMachineConstants {
	public static String VENDING_MACHINE_MONEY_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static String VENDING_MACHINE_MONEY_OUTPUT_MESSAGE = "자판기가 보유한 동전";
	public static String PRODUCTS_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static String USER_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	public static String USER_INPUT_MONEY_MESSAGE = "투입 금액: ";

	public static String ERROR_PREFIX = "[ERROR] ";
	public static String MONEY_NOT_DIGIT_ERROR = "금액은 숫자여야 합니다.";
	public static String MONEY_NEGATIVE_NUM_ERROR = "금액은 양수여야 합니다.";
	public static String PRODUCT_COVER_ERROR = "개별 상품은 대괄호로 묶어야 합니다.";
	public static String PRODUCT_FORMAT_ERROR = "개별 상품은 [상품명, 100원 이상의 가격, 수량]의 형태로 입력되어야 합니다.";
	public static String PRODUCT_PRICE_ERROR = "금액은 10원으로 나누어떨어져야 합니다.";
	public static String PRODUCT_AMOUNT_ERROR = "상품의 수량은 0이상이어야 합니다.";
	public static String PRODUCT_EMPTY_ERROR = "상품의 내용을 입력하여야 합니다";

	public static Integer COIN_500_NUM = 500;
	public static Integer COIN_100_NUM = 100;
	public static Integer COIN_50_NUM = 50;
	public static Integer COIN_10_NUM = 10;

	public static Integer COIN_500_IDX = 0;
	public static Integer COIN_100_IDX = 1;
	public static Integer COIN_50_IDX = 2;
	public static Integer COIN_10_IDX = 3;

	public static String KOR_MONETARY_UNIT = "원";
	public static String DASH_WITH_SPACE = " - ";
	public static String SPACE = " ";
	public static String KOR_ITEM_UNIT = "개";

}
