package view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputDisplay {
	private static final String PRICE = "원 - ";
	private static final String COUNT = "개";
	private static final String VENDING_MACHINE_HOLDING_COIN_MESSAGE = "자판기가 보유한 동전";

	private OutputDisplay() {
	}

	public static void showEachCoinInCoinBox(List<Integer> eachCoinPrice, List<Integer> eachCoinCount) {
		System.out.println();
		System.out.println(VENDING_MACHINE_HOLDING_COIN_MESSAGE);
		IntStream.range(0, eachCoinCount.size())
			.forEach(index -> showCoin(eachCoinPrice.get(index), eachCoinCount.get(index)));
	}

	private static void showCoin(int coinPrice, int coinCount) {
		System.out.println(coinPrice + PRICE + coinCount + COUNT);
	}

	public static void showNowUserInsertMoney(int userInsertMoney) {
		System.out.println();
		System.out.println("투입 금액: " + userInsertMoney + "원");
	}
}
