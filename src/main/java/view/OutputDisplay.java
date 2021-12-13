package view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputDisplay {
	private static final int FIRST_INDEX = 0;
	private static final String PRICE = "원 - ";
	private static final String COUNT = "개";
	private static final String INSERTED_MONEY = "투입 금액: ";
	private static final String UNIT_OF_MONEY = "원";
	private static final String VENDING_MACHINE_HOLDING_COIN_MESSAGE = "자판기가 보유한 동전";

	private OutputDisplay() {
	}

	public static void showCoinsInCoinBox(List<Integer> priceOfCoins, List<Integer> countOfCoins) {
		System.out.println();
		System.out.println(VENDING_MACHINE_HOLDING_COIN_MESSAGE);
		IntStream.range(FIRST_INDEX, countOfCoins.size())
			.forEach(index -> showCoinInformation(priceOfCoins.get(index), countOfCoins.get(index)));
	}

	private static void showCoinInformation(int coinPrice, int coinCount) {
		System.out.println(coinPrice + PRICE + coinCount + COUNT);
	}

	public static void showNowInsertedMoney(int nowInsertedMoney) {
		System.out.println();
		System.out.println(INSERTED_MONEY + nowInsertedMoney + UNIT_OF_MONEY);
	}
}
