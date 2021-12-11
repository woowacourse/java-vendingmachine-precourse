package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class ChangeMessage {

	public static final String IN_PROGRESS = "잔돈";
	public static final String MONEY_UNIT = "원 - ";
	public static final String COIN_UNIT = "개\n";

	public static void printInProgress() {
		System.out.println(IN_PROGRESS);
	}

	public static void printChanges(Map<Coin, Integer> changeMap) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Coin, Integer> entry : changeMap.entrySet()) {
			if (entry.getValue() != 0) {
				builder.append(entry.getKey().getAmount())
					.append(MONEY_UNIT)
					.append(entry.getValue())
					.append(COIN_UNIT);
			}
		}
		builder.deleteCharAt(builder.lastIndexOf("\n"));
		System.out.println(builder);
	}
}
