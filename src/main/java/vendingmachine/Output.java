package vendingmachine;

import java.util.Collections;
import java.util.List;

public class Output {
	private static final String SET_MONEY_MSG = "\n투입 금액: ";
	private static final String HOLDING_AMOUNT = "\n자판기가 보유한 동전";
	private static final String HYPHEN = " - ";
	private static final String CHANGE = "잔돈";
	private static final String COUNT = "개";
	private static final String WON = "원";

	public static void changeMoney(List coinList, List coinType) {
		System.out.println(CHANGE);
		for (int i = 0; i < coinType.size(); i++) {
			int count = Collections.frequency(coinList, coinType.get(i));
			print((Integer)coinType.get(i), count);
		}
	}

	public static void numberOfCoin(List coinList) {
		System.out.println(HOLDING_AMOUNT);
		countCoin500(coinList);
		countCoin100(coinList);
		countCoin50(coinList);
		countCoin10(coinList);
	}

	public static void countCoin500(List coinList) {
		int count = Collections.frequency(coinList, Coin.COIN_500.getAmount());
		print(Coin.COIN_500, count);
	}

	public static void countCoin100(List coinList) {
		int count = Collections.frequency(coinList, Coin.COIN_100.getAmount());
		print(Coin.COIN_100, count);
	}

	public static void countCoin50(List coinList) {
		int count = Collections.frequency(coinList, Coin.COIN_50.getAmount());
		print(Coin.COIN_50, count);
	}

	public static void countCoin10(List coinList) {
		int count = Collections.frequency(coinList, Coin.COIN_10.getAmount());
		print(Coin.COIN_10, count);
	}

	public static void print(Coin amount, int count) {
		System.out.println(amount + WON + HYPHEN + count + COUNT);
	}

	public static void print(int amount, int count) {
		System.out.println(amount + WON + HYPHEN + count + COUNT);
	}

	public static void printMoney(int Money) {
		System.out.println(SET_MONEY_MSG + Money + WON);
	}
}
