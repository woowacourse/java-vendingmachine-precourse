package vendingmachine.coin;

import java.util.Map;

public class Coins {
	private final Map<Coin, Integer> coins;

	protected Coins(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<Coin, Integer> coin : coins.entrySet()) {
			stringBuilder
				.append(coin.getKey()).append(" - ")
				.append(coin.getValue()).append("개\n");
		}
		return stringBuilder.toString();
	}
}
