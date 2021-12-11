package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class OutputView {
	public static void inputHoldingCoin(Map<Coin, Integer> holdingCoin) {
		holdingCoin.entrySet()
			.stream()
			.map(e -> String.join("\n", e.getKey().getAmount() + "원 - " + e.getValue() + "개"))
			.forEach(System.out::println);
	}
}
