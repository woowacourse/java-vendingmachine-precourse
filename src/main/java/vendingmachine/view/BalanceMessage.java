package vendingmachine.view;

import java.util.Map;

public class BalanceMessage {
	private static final String ENTER_BALANCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String BALANCE_TITLE = "\n자판기가 보유한 동전\n";
	public static final String MONEY_UNIT = "원 - ";
	public static final String QUANTITY_UNIT = "개\n";

	public static void printInputMessage() {
		System.out.println(ENTER_BALANCE);
	}

	public static void printCoinList(Map<Integer, Integer> balanceMap) {
		StringBuilder builder = new StringBuilder();
		builder.append(BALANCE_TITLE);
		balanceMap.forEach((key, value) -> builder.append(key)
			.append(MONEY_UNIT)
			.append(value)
			.append(QUANTITY_UNIT));
		System.out.println(builder);
	}
}
