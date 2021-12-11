package vendingmachine.constants;

public class InputConstants {
	public static String ASK_STORAGE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static String ASK_PRODUCT_LIST = "상품명과 가격, 수량을 입력해 주세요.";
	public static String ASK_USER_MONEY = "투입 금액을 입력해 주세요.";

	public static String ERROR = "[ERROR] %s";
	public static String ERROR_STORAGE_MONEY = "보유금액은 숫자이어야 합니다.";
	public static String ERROR_MONEY_DIVISION = "금액은 10으로 나누어 떨어져야합니다.";
	public static String ERROR_PRODUCT_LIST = "상품의 형식을 맞춰주세요 [상품명1,가격,수량];[상품명2,가격,수량];...";
	public static String PRODUCT_DELIMITER = ";";
	public static String PRODUCT_CONTENT_DELIMITER = ",";

	public static int PRODUCT_CONTENT_SIZE = 3;
}
