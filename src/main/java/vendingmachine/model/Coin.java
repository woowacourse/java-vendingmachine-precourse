package vendingmachine.model;

import java.util.ArrayList;
import java.util.Collections;
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

	public final int getAmount() {
		return amount;
	}

	public static final int getAmount(String name) {

		for (Coin coin : Coin.values()) {

			if (coin.name().equals(name)) {
				return coin.getAmount();
			}

		}

		return -1;
	}

	public static List<Integer> getAmountList() {
		List<Integer> amountList = new ArrayList<>();

		for (Coin coin : Coin.values()) {
			amountList.add(coin.getAmount());
		}

		return amountList;
	}

	public static final int minAmount() {
		return Collections.min(Coin.getAmountList());
	}

	public static String getName(int amount) {

		for (Coin coin : Coin.values()) {

			if (coin.getAmount() == amount) {
				return coin.name();
			}

		}

		return null;
	}
}
