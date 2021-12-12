package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vendingmachine.type.Coin;

public class VendingMachineCoins {

	private final Map<Coin, Integer> coins;

	public VendingMachineCoins(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	public List<Coin> getKeys() {
		return new ArrayList<>(coins.keySet());
	}

	public int getAmount(Coin coin) {
		return coins.get(coin);
	}
}
