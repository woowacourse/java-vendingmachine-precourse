package view;

import java.util.Map;

public class OutputDisplay {
	private static final int FIRST_INDEX = 0;
	private static final String PRICE = "원 - ";
	private static final String COUNT = "개";
	private static final String INSERTED_MONEY = "투입 금액: ";
	private static final String UNIT_OF_MONEY = "원";
	private static final String VENDING_MACHINE_HOLDING_COIN_MESSAGE = "자판기가 보유한 동전";

	private OutputDisplay() {
	}

	public static void showAllCoinInCoinBox(Map<Integer, Integer> eachCoins) {
		System.out.println();
		System.out.println(VENDING_MACHINE_HOLDING_COIN_MESSAGE);
		for (Map.Entry<Integer, Integer> coin : eachCoins.entrySet()) {
			showCoinInformation(coin.getKey(), coin.getValue());
		}
	}

	private static void showCoinInformation(int coinPrice, int coinCount) {
		System.out.println(coinPrice + PRICE + coinCount + COUNT);
	}

	public static void showNowInsertedMoney(int nowInsertedMoney) {
		System.out.println();
		System.out.println(INSERTED_MONEY + nowInsertedMoney + UNIT_OF_MONEY);
	}

	public static void showChangeAsCoins(Map<Integer, Integer> changeCoins) {
		for (Map.Entry<Integer, Integer> coin : changeCoins.entrySet()) {
			showCoinInformation(coin.getKey(), coin.getValue());
		}
	}
}
