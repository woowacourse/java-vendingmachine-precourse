package vendingmachine.dto;

import java.util.Map;

import vendingmachine.domain.Quantity;
import vendingmachine.enums.Coin;

public class ResponseAllCoinQuantityDto {
	private Map<Coin, Quantity> coins;

	public ResponseAllCoinQuantityDto(Map<Coin, Quantity> coins) {
		this.coins = coins;
	}

	public Map<Coin, Quantity> getCoins() {
		return coins;
	}
}
