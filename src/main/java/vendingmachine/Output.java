package vendingmachine;

import java.util.Collections;
import java.util.List;

public class Output {
	private static final String WON = "원";
	private static final String HYPHEN = " - ";
	private static final String COUNT = "개";

	public static void numberOfCoin(List coinList) {
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
}
