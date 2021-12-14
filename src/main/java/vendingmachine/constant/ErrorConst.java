package vendingmachine.constant;

public class ErrorConst {
	public static String MONEY_IS_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	public static String MONEY_IS_NOT_MINUS = "[ERROR] 금액은 자연수여야 합니다.";
	public static String MONEY_IS_DIVIDED_BY_TEN = "[ERROR] 금액은 10원 단위로 나누어 떨어져야합니다.";
	public static String COIN_IS_NOT_VALID = "[ERROR] 해당 금액의 동전은 존재하지 않습니다.";

	public static String ITEM_OUT_OF_FORMAT = "[ERROR] 상품은 지정된 형식으로 넣어야합니다.";
	public static String ITEM_PRICE_OVER_ONE_HUNDRED = "[ERROR] 상품의 가격은 100원 이상이여야 합니다.";
	public static String ITEM_NAME_IS_NOT_WHITESPACE = "[ERROR] 상품명으로 공백을 지정할 수 없습니다.";
	public static String DUP_ITEM_NAME = "[ERROR] 상품명은 중복되면 안됩니다.";

	public static String HAVE_NO_THIS_ITEM = "[ERROR] 입력한 상품은 존재하지 않습니다.";
	public static String HAVE_NO_STOCK = "[ERROR] 해당 상품의 재고가 존재하지 않습니다.";
	public static String HAVE_NO_AFFORDABLE_MONEY = "[ERROR] 해당 상품을 사기엔 투입 금액이 부족합니다.";
}
