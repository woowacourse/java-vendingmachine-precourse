package vendingmachine;

import java.util.List;
import java.util.ArrayList;

public enum Coin {
	COIN_500(500), COIN_100(100), COIN_50(50), COIN_10(10);

	final static String ERROR_NOT_COIN = "[ERROR] 존재하지않는 COIN입니다.";

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static List<Integer> coinList() {
		List<Integer> list = new ArrayList<>();
		for (Coin money : Coin.values()) {
			list.add(money.amount);
		}
		return list;
	}

	public static Coin getCoinKeyNumber(int checkMoney) {
		for (Coin money : Coin.values()) {
			if (money.amount == checkMoney) {
				return money;
			}
		}
		throw new IllegalArgumentException(ERROR_NOT_COIN);

	}

}
