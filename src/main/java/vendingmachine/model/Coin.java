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
		String name = "";

		for (Coin coin : Coin.values()) {

			if (coin.getAmount() == amount) {
				name = coin.name();
			}

		}

		return name;
	}
}
