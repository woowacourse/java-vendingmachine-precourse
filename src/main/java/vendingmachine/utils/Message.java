package vendingmachine.utils;

public class Message {
	public static final String  ASK_HOLDING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String  ASK_ADD_ITEMS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String  ASK_INPUT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	public static final String  HOLDING_COINS_MESSAGE = "자판기가 보유한 동전";

	public static final String  NON_NUMERIC_HOLDING_MONEY_ERROR = "[ERROR] 보유 금액은 양의 정수를 입력하셔야 합니다.";
	public static final String  ZERO_HOLDING_MONEY_ERROR = "[ERROR] 보유 금액은 0이 아닌 양의 정수를 입력하셔야 합니다.";
	public static final String  DIVIDED_BY_TEN_HOLDING_MONEY_ERROR = "[ERROR] 보유 금액은 10으로 나누어 떨어져야 합니다.";

}
