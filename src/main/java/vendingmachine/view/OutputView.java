package vendingmachine.view;

import java.util.LinkedHashMap;

public class OutputView {
	private static final String DISPLAY_MACHINE_COIN_MSG = "자판기가 보유한 동전";
	private static final String DISPLAY_USER_MONEY_MSG = "투입 금액";
	private static final String COIN_UNIT_WON = "원";
	private static final String COIN_COUNT_UNIT = "개";

	public void displayGeneratedCoin(LinkedHashMap<Integer, Integer> coinCount) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(DISPLAY_MACHINE_COIN_MSG);

		coinCount.forEach((coin, count) -> {
			sb.append("\n").append(coin.toString()).append(COIN_UNIT_WON).append(" - ")
				.append(count.toString()).append(COIN_COUNT_UNIT);
		});

		System.out.println(sb);
	}

	public void displayUserMoney(int change) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(DISPLAY_USER_MONEY_MSG).append(": ")
			.append(Integer.toString(change)).append(COIN_UNIT_WON);

		System.out.println(sb);
	}
}
