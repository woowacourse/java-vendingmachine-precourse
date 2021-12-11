package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static vendingmachine.utils.Constant.*;

public class Coins {

	private Map<Coin, Integer> list;

	public Coins() {
		list = initializeCoins();
	}

	public Map<Coin, Integer> getList() {
		return list;
	}

	public void insertRandomCoins(int totalAmount) {
		while (totalAmount != ZERO) {
			Coin coin = Coin.pickRandom();

			if (totalAmount >= coin.getAmount()) {
				totalAmount -= coin.getAmount();
				list.put(coin, list.get(coin) + ONE);
			}
		}
	}

	private Map<Coin, Integer> initializeCoins() {
		list = new LinkedHashMap<>();

		Arrays.stream(Coin.values())
			.forEach(coin -> list.put(coin, DEFAULT_QUANTITY));

		return list;
	}
}
