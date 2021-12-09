package vendingmachine.constant;

import vendingmachine.model.Coin;

public class Message {

	public static final String INPUT_MESSAGE_HOlDING_SUM = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static final String OUTPUT_MESSAGE_HOLDING_SUM = "자판기가 보유한 동전";

	public static final String ERROR = "[ERROR]";
	public static final String ERROR_MESSAGE_POSITIVE_NUMBER = Coin.minAmount() + "원 이상의 정수를 입력해 주세요.";
	public static final String ERROR_MESSAGE_EXCEED_INTEGER = Integer.MAX_VALUE + "이하의 정수를 입력해 주세요.";
	public static final String ERROR_MESSAGE_DIVISIBLE_NUMBER = Coin.minAmount() + "원 단위의 정수를 입력해 주세요.";
}
