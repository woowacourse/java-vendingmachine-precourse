package vendingmachine.view;

import java.util.LinkedHashMap;

public class OutputView {
	private static final String GENERATED_COIN_MSG = "자판기가 보유한 동전";
	private static final String COIN_WON_MSG = "원 - ";
	private static final String COIN_COUNT_UNIT = "개";

	public void displayGeneratedCoin(LinkedHashMap<Integer, Integer> coinCount) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(GENERATED_COIN_MSG);

		coinCount.forEach((coin, count) -> {
			sb.append("\n").append(coin.toString()).append(COIN_WON_MSG)
				.append(count.toString()).append(COIN_COUNT_UNIT);
		});

		System.out.println(sb);
	}
}
