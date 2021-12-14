package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Coin;

public class OutputView {
	private final static String COIN_NUMBER_MESSAGE = "\n자판기가 보유한 동전";
	private final static String MONEY_UNIT = "원";
	private final static String DASH = " - ";
	private final static String NUMBER_UNIT = "개";
	private final static String USER_AMOUNT_MESSAGE = "\n투입 금액: ";
	private final static String RETURN_COIN_MESSAGE = "잔돈";

	public void printCoinNumberMessage(HashMap<Coin, Integer> coins) {
		System.out.println(COIN_NUMBER_MESSAGE);
		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + MONEY_UNIT + DASH + coins.get(coin) + NUMBER_UNIT);
		}
	}

	public void printUserAmount(int userAmount) {
		System.out.println(USER_AMOUNT_MESSAGE + userAmount + MONEY_UNIT);
	}

	public void printReturnCoin(HashMap<Coin, Integer> returnCoins) {
		System.out.println(RETURN_COIN_MESSAGE);
		for (Coin coin : Coin.values()) {
			if (returnCoins.containsKey(coin)) {
				System.out.println(coin.getAmount() + MONEY_UNIT + DASH + returnCoins.get(coin) + NUMBER_UNIT);
			}
		}
	}
}
