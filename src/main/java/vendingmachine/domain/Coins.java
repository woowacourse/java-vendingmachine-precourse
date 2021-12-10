package vendingmachine.domain;

import static vendingmachine.utils.Random.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coins {

	private Map<Coin, Integer> list;

	public Coins() {
		list = initializeCoins();
	}

	private Map<Coin, Integer> initializeCoins() {
		list = new HashMap<>();

		Arrays.stream(Coin.values())
			.forEach(coin -> list.put(coin, 0));

		return list;
	}

	public Map<Coin, Integer> getList() {
		return list;
	}

	public void insertRandomCoins(int totalAmount) {
		while (totalAmount != 0) {
			Coin coin = pickCoin();

			if (totalAmount >= coin.getAmount()) {
				totalAmount -= coin.getAmount();
				list.put(coin, list.get(coin) + 1);
			}
		}
	}

	private Coin pickCoin() {
		int amount = pickRandomCoin(Coin.getAmounts());
		return Coin.getCoin(amount);
	}

	public void print() {
		list.forEach(((coin, integer) -> System.out.println(coin + "  " + integer)));
	}


}
