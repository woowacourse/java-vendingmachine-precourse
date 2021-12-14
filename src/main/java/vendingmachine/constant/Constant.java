package vendingmachine.constant;

public class Constant {
	public static final String NO_STOCKS_MESSAGE = "[ERROR] 재고가 남아있지 않습니다.";
	public static final String DUPLICATED_ITEM_MESSAGE = "[ERROR] 이미 해당 상품이 존재합니다.";
	public static final String NO_ANY_COIN = "[ERROR] 코인이 등록되어있지 않습니다.";
	public static final String MONEY_SMALLER_THAN_MINIMUM_COIN = "[ERROR] 돈의 단위가 코인의 제일 작은 단위보다 작습니다.";
	public static final String DISTINGUISH_BETWEEN_PRODUCTS = ";";
	public static final String DISTINGUISH_BETWEEN_PRODUCT_INFORMATION = ",";
	public static final String ENTER_VENDING_MACHINE_INITIAL_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
	public static final String RULES_TO_SHOW = "원 - ";
	public static final String WON = "원";
	public static final String NUMBER = "개";
	public static final String ENTER_PRODUCT_AND_NUMBER = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ENTER_INPUT_MONEY = "투입 금액을 입력해 주세요.";
	public static final String INPUT_MONEY = "투입 금액: ";
	public static final String REMAINING_MONEY = "잔돈";
	public static final String ENTER_WANT_TO_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";
	public static final String REGEX_EXPRESSION_OF_NUMBER = "[+-]?\\d*(\\.\\d+)?";
	public static final int NAME = 0;
	public static final int PRICE = 1;
	public static final int STOCKS = 2;
}
