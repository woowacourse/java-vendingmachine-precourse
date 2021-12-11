package vendingmachine.view;

import java.util.Arrays;
import java.util.List;

public class ChangeMessage {

	public static final String IN_PROGRESS = "잔돈";
	public static final String MONEY_UNIT = "원 - ";
	public static final String COIN_UNIT = "개\n";

	public static void printInProgress() {
		System.out.println(IN_PROGRESS);
	}

	public static void printChanges(List<Integer> changeCount) {
		List<Integer> coinList = Arrays.asList(500, 100, 50, 10);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < coinList.size(); i++) {
			if (changeCount.get(i) != 0) {
				builder.append(coinList.get(i))
					.append(MONEY_UNIT)
					.append(changeCount.get(i))
					.append(COIN_UNIT);
			}
		}
		builder.deleteCharAt(builder.lastIndexOf("\n"));
		System.out.println(builder);
	}
}
