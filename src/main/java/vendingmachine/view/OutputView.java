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

		System.out.println(makeDisplayCoinMsg(coinCount, sb));
	}

	private StringBuilder makeDisplayCoinMsg(LinkedHashMap<Integer, Integer> coinInfo, StringBuilder sb) {
		coinInfo.forEach((coin, count) -> {
			sb.append("\n").append(coin.toString()).append(COIN_UNIT_WON)
				.append(" - ").append(count.toString()).append(COIN_COUNT_UNIT);
		});

		return sb;
	}

	public void displayUserMoney(int change) {
		String msg = "\n" + DISPLAY_USER_MONEY_MSG + ": " + Integer.toString(change) + COIN_UNIT_WON;
		System.out.println(msg);
	}

	public void displayChange(LinkedHashMap<Integer, Integer> changeInfo) {
		StringBuilder sb = new StringBuilder();
		sb.append(DISPLAY_CHANGE_MSG);

		System.out.println(makeDisplayCoinMsg(changeInfo, sb));
	}
}
