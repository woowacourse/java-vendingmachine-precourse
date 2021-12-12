package vendingmachine.dto;

import java.util.HashMap;

import vendingmachine.domain.Quantity;
import vendingmachine.enums.Coin;

public class ResponseAllCoinQuantity {
	private HashMap<Coin, Quantity> coins;

	public ResponseAllCoinQuantity(HashMap<Coin, Quantity> coins) {
		this.coins = coins;
	}

	public HashMap<Coin, Quantity> getCoins() {
		return coins;
	}
}
