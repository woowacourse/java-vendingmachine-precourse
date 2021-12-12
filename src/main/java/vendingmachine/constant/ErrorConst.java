package vendingmachine.constant;

public class ErrorConst {
	public static String MONEY_IS_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	public static String MONEY_IS_NOT_MINUS = "[ERROR] 금액은 자연수여야 합니다.";
	public static String MONEY_IS_DIVIDED_BY_TEN = "[ERROR] 금액은 10원 단위로 나누어 떨어져야합니다.";
	public static String ITEM_OUT_OF_FORMAT = "[ERROR] 상품은 지정된 형식으로 넣어야합니다.";
	public static String ITEM_PRICE_OVER_ONE_HUNDRED = "[ERROR] 상품의 가격은 100원 이상이여야 합니다.";
}
