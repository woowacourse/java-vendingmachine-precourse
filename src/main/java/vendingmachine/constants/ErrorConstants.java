package vendingmachine.constants;

public class ErrorConstants {
	public static String ERROR_MONEY_NUMBER = "[ERROR] 금액은 숫자이어야 합니다.";
	public static String ERROR_MONEY_DIVISION = "[ERROR] 금액은 10으로 나누어 떨어져야합니다.";

	public static String ERROR_STORAGE_NUMBER_RANGE = "[ERROR 보유 금액은 10이상이어야 합니다.";
	public static String ERROR_PRODUCT_FORMAT = "[ERROR] 상품은 []로 감싸져야 합니다.";
	public static String ERROR_PRODUCT_CONTENT_SIZE = "[ERROR] 상품의 이름, 가격, 수량을 모두 입력하세요.";
	public static String ERROR_PRODUCT_PRICE_RANGE = "[ERROR] 상품의 가격은 100이상이어야 합니다.";
	public static String ERROR_PRODUCT_QUANTITY_RANGE = "[ERROR] 상품의 개수는 1이상이어야 합니다.";
}
