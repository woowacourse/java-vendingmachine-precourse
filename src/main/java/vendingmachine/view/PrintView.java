package vendingmachine.view;

import static constant.CharacterConstant.*;
import static constant.StringConstant.*;

import java.util.Map;

import vendingmachine.Coin;

public class PrintView {
	public static void printVendingMachineCoins(Map<Coin,Integer> coins) {
		System.out.println(LINE_STAMP + COIN_CONTAIN_MESSAGE);
		for (Coin coin : coins.keySet()) {
			String coinMessage = coin.getAmount()
				+ PRICE_UNIT + COIN_AMOUNT_CONNECTION
				+ coins.get(coin) + COIN_QUANTITY_UNIT;
			System.out.println(coinMessage);
		}
	}

	public static void printVendingMachineBalance() {

	}

	public static void printChange() {

	}
}
