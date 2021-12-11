package vendingmachine.coin;

import java.util.Map;

import vendingmachine.quantity.Quantity;

public class Coins {
	private final Map<Coin, Quantity> coins;

	protected Coins(Map<Coin, Quantity> coins) {
		this.coins = coins;
	}

	public boolean isEmpty() {
		return coins.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<Coin, Quantity> coin : coins.entrySet()) {
			stringBuilder
				.append(coin.getKey()).append(" - ")
				.append(coin.getValue()).append("\n");
		}
		return stringBuilder.toString();
	}
}
