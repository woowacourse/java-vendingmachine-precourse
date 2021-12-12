package vendingmachine.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import vendingmachine.type.Coin;

public class VendingMachineCoins {

	private final Map<Coin, Integer> coins;

	public VendingMachineCoins(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	public List<Coin> getKeys() {
		return coins.keySet().stream()
			.collect(Collectors.toList());
	}

	public int getAmount(Coin coin) {
		return coins.get(coin);
	}
}
