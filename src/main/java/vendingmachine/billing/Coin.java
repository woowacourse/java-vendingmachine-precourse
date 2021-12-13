package vendingmachine.billing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static int getRandomCoin() {
		List<Integer> coins = Arrays.stream(Coin.values()).map(coin -> coin.amount).collect(Collectors.toList());
		return Randoms.pickNumberInList(coins);
	}

	public static Coin issue(int amount) {
		HashMap<Integer, Coin> coinMap = new HashMap<>();
		for (Coin each : Coin.values()) {
			coinMap.put(each.amount, each);
		}
		return coinMap.get(amount);
	}

	public void change(Money money) {
		money.change(amount);
	}

	public boolean isChangeable(Money money) {
		return money.isChangeable(amount);
	}

	public String toString() {
		return String.valueOf(amount);
	}
}
