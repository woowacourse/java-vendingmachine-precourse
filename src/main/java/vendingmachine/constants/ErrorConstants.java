package vendingmachine.constants;

public class ErrorConstants {
	public static String ERROR_NUMBER = "[ERROR] 금액과 수량은 숫자이어야 합니다.";
	public static String ERROR_MONEY_DIVISION = "[ERROR] 금액은 10으로 나누어 떨어져야합니다.";
	public static String ERROR_MONEY_ZERO = "[ERROR] 금액은 0이 될 수 없습니다.";
	public static String ERROR_MONEY_RANGE = "[ERROR] 상품 가격과 투입 금액은 100 이상이어야 합니다.";

	public static String ERROR_PRODUCT_NAME_REDUNDANT = "[ERROR] 상품명은 중복될 수 없습니다.";
	public static String ERROR_PRODUCT_FORMAT = "[ERROR] 상품은 []로 구분되어야 합니다.";
	public static String ERROR_PRODUCT_CONTENT_SIZE = "[ERROR] 상품의 이름, 가격, 수량을 모두 입력하세요.";
	public static String ERROR_PRODUCT_QUANTITY_RANGE = "[ERROR] 상품의 개수는 1이상이어야 합니다.";
	public static String ERROR_PRODUCT_NOT_EXIST = "[ERROR] 상품을 찾을 수 없습니다.";
}
