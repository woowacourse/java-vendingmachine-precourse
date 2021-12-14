package vendingmachine.constant;

public class OrderConstant {

	public static int COIN_STCOK_INIT_VAL = 0;

	public static String NUMERIC_REGEX = "[0-9]+";

	public static String PRICE_NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 투입 금액은 숫자여야 합니다.";
	public static String NON_EXIST_ERROR_MESSAGE = "[ERROR] 존재하지 않는 상품입니다.";
	public static String EXPENSIVE_ERROR_MESSAGE = "[ERROR] 잔돈보다 가격이 비싼 상품을 선택했습니다.";
	public static String NON_STOCK_ERROR_MESSAGE = "[ERROR] 재고가 없습니다.";

}