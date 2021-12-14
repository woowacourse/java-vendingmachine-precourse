package vendingmachine.view;

import java.util.LinkedHashMap;

public class OutputView {
	private static final String DISPLAY_MACHINE_COIN_MSG = "자판기가 보유한 동전";
	private static final String DISPLAY_USER_MONEY_MSG = "투입 금액";
	private static final String DISPLAY_CHANGE_MSG = "잔돈";
	private static final String COIN_UNIT_WON = "원";
	private static final String COIN_COUNT_UNIT = "개";

	public void displayGeneratedCoin(LinkedHashMap<Integer, Integer> coinCount) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(DISPLAY_MACHINE_COIN_MSG);

		coinCount.forEach((coin, count) -> {
			sb.append(makeDisplayCoinMsg(coin, count));
		});

		System.out.println(sb);
	}

	private StringBuilder makeDisplayCoinMsg(Integer coin, Integer count) {
		return new StringBuilder().append("\n").append(coin.toString()).append(COIN_UNIT_WON)
			.append(" - ").append(count.toString()).append(COIN_COUNT_UNIT);
	}

	public void displayUserMoney(int change) {
		String msg = "\n" + DISPLAY_USER_MONEY_MSG + ": " + Integer.toString(change) + COIN_UNIT_WON;
		System.out.println(msg);
	}

	public void displayChange(LinkedHashMap<Integer, Integer> change) {
		StringBuilder sb = new StringBuilder();
		sb.append(DISPLAY_CHANGE_MSG);

		change.forEach((coin, count) -> {
			if (count > 0) {
				sb.append(makeDisplayCoinMsg(coin, count));
			}
		});

		System.out.println(sb);
	}
}
