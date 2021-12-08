package vendingmachine.repository;

import java.util.HashMap;

import vendingmachine.domain.Coin;

public class VendingMachine {
	private final HashMap<Coin, Integer> coins;

	public VendingMachine() {
		this.coins = new HashMap<>();
	}

	public void addCoin(Coin coin) {
		coins.put(coin, coins.getOrDefault(coin, 0) + 1);
	}

}
