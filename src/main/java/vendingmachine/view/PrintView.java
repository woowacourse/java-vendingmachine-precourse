package vendingmachine.view;

import static constant.CharacterConstant.*;
import static constant.StringConstant.*;

import java.util.Map;

import vendingmachine.model.Coin;

public class PrintView {
	public static void printVendingMachineCoins(Map<Coin,Integer> coins) {
		System.out.println(LINE_STAMP + COIN_CONTAIN_MESSAGE);
		for (Coin coin : coins.keySet()) {
			printCoinState(coins, coin);
		}
	}

	private static void printCoinState(Map<Coin, Integer> coins, Coin coin) {
		String coinMessage = coin.getAmount()
			+ PRICE_UNIT + COIN_AMOUNT_CONNECTION
			+ coins.get(coin) + COIN_QUANTITY_UNIT;
		System.out.println(coinMessage);
	}

	public static void printMoneyState(int balance) {
		System.out.println(INSERT_MONEY_STATE + balance + PRICE_UNIT);
	}

	public static void printChange() {

	}
}
