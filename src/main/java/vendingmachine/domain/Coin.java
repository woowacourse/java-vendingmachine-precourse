package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> getPossibleQuantity(Coin coin, int balance) {
		List<Integer> list = new ArrayList<>();
		for (int quantity = 0; quantity <= getMaxQuantity(coin, balance); quantity++) {
			list.add(quantity);
		}
		return list;
	}

	public static int calculateResidue(Coin coin, int balance, int quantity) {
		return balance - coin.amount * quantity;
	}

	public static int getMaxQuantity(Coin coin, int balance) {
		return balance / coin.amount;
	}

	public static int getAmount(Coin coin) {
		return coin.amount;
	}
}
