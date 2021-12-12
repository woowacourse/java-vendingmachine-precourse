package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Quantity;
import vendingmachine.dto.ResponseAllCoinQuantity;
import vendingmachine.enums.Coin;

public class OutputView {
	private static final String RESPONSE_ALL_COIN_QUANTITY_MESSAGE = "자판기가 보유한 동전";
	private static final String RESPONSE_ALL_COIN_QUANTITY_FORM = "%d원 - %d개";

	public static void outputAllCoinQuantity(ResponseAllCoinQuantity responseAllCoinQuantity) {
		HashMap<Coin, Quantity> coins = responseAllCoinQuantity.getCoins();
		System.out.println(RESPONSE_ALL_COIN_QUANTITY_MESSAGE);
		for (Coin coin : Coin.values()) {
			int amount = coin.get();
			int quantity = coins.get(coin).get();
			String message = String.format(RESPONSE_ALL_COIN_QUANTITY_FORM, amount, quantity);
			System.out.println(message);
		}
	}
}
