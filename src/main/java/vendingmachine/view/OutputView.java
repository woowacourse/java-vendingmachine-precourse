package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Change;
import vendingmachine.domain.Quantity;
import vendingmachine.dto.ResponseAllCoinQuantity;
import vendingmachine.dto.ResponseChangeDto;
import vendingmachine.dto.ResponseMoneyDto;
import vendingmachine.enums.Coin;

public class OutputView {
	private static final String RESPONSE_ALL_COIN_QUANTITY_MESSAGE = "자판기가 보유한 동전";
	private static final String RESPONSE_CHANGE_QUANTITY_MESSAGE = "잔돈";
	private static final String RESPONSE_COIN_QUANTITY_FORM = "%d원 - %d개";
	private static final String RESPONSE_NOW_MONEY_FORM = "투입 금액: %d원";

	public static void outputAllCoinQuantity(ResponseAllCoinQuantity responseAllCoinQuantity) {
		HashMap<Coin, Quantity> coins = responseAllCoinQuantity.getCoins();
		System.out.println(RESPONSE_ALL_COIN_QUANTITY_MESSAGE);
		for (Coin coin : Coin.values()) {
			int amount = coin.get();
			int quantity = coins.get(coin).get();
			String message = String.format(RESPONSE_COIN_QUANTITY_FORM, amount, quantity);
			System.out.println(message);
		}
		System.out.println();
	}

	public static void outputNowMoney(ResponseMoneyDto responseMoneyDto) {
		String nowMoneyMessage = String.format(RESPONSE_NOW_MONEY_FORM, responseMoneyDto.getMoney().get());
		System.out.println(nowMoneyMessage);
	}

	public static void outputChange(ResponseChangeDto responseChangeDto) {
		System.out.println(RESPONSE_CHANGE_QUANTITY_MESSAGE);
		Change change = responseChangeDto.getChange();
		for (Coin coin : Coin.values()) {
			Quantity quantity = change.get(coin);
			if (quantity.has()) {
				String message = String.format(RESPONSE_COIN_QUANTITY_FORM, coin.get(), quantity.get());
				System.out.println(message);
			}
		}
	}
}
