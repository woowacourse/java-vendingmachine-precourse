package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class Changes {
	private Map<Coin, Integer> changes = new HashMap<>();

	public Changes(int money) {
		for (Coin coin : Coin.values()) {
			int coinNum = coin.randomPick(money);
			changes.put(coin, coinNum);
			money = coin.getRemainMoney(money, coinNum);
		}
	}
}
