package vendingmachine.constant;

public final class PromptConstant {
	public static final int ONE_GOODS_VALID = 0;
	public static final int PRICE_INVALID = 1;
	public static final int COUNT_INVALID = 2;
	public static final String GOODS_CLASSIFY_DELI = ";";
	public static final char GOODS_START_DELI = '[';
	public static final char GOODS_END_DELI = ']';
	public final static String NUMBER_REGEX = "^[+-]?[0-9]*$";
	public final static String WON_STRING = "원";
	public final static String COUNT_STRING = "개";
	public final static String CHANGE_STRING = "잔돈";
	public final static String PROMPT_VENDING_MACHINE_HAVE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public final static String PROMPT_VENDING_MACHINE_HAVE_COINS = "자판기가 보유한 동전";
	public final static String PROMPT_VENDING_MACHINE_GOODS_AND_PRICES = "상품명과 가격, 수량을 입력해 주세요.";
	public final static String PROMPT_USER_INSERT_MONEY = "투입 금액을 입력해 주세요.";
	public final static String PROMPT_SHOW_INSERTED_MONEY = "투입 금액: ";
	public final static String PROMPT_USER_INPUT_GOODS = "구매할 상품명을 입력해 주세요.";
}
