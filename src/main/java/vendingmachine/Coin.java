package vendingmachine;

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

	public int getAmount() {
		return amount;
	}

	public static List<Integer> getAmountList() {
		List<Integer> amountList = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			amountList.add(coin.amount);
		}
		return amountList;
	}

	public static Coin findToAmount(int amount) {
		for (Coin coin : Coin.values()) {
			if (coin.amount == amount) {
				return coin;
			}
		}
		return null;
	}
}
