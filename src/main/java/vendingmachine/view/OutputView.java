package vendingmachine.view;

import java.util.LinkedHashMap;

public class OutputView {
	private static final String VENDING_MACHINE_HAVING_COIN_STATUS = "자판기가 보유한 동전";
	private static final String COIN_VALUE_UNIT = "원";
	private static final String COIN_COUNT_UNIT = "개";
	private static final String HYPHEN = " - ";
	private static final String INPUT_MONEY_STATUS = "투입 금액: ";
	private static final String CHANGE_MONEY_STATUS = "잔돈";

	public static void showVendingMachineCoinStatus(
			LinkedHashMap<Integer, Integer> vendingMachineCoinStatus) {
		System.out.println();
		System.out.println(VENDING_MACHINE_HAVING_COIN_STATUS);
		for (Integer coinValueUnit : vendingMachineCoinStatus.keySet()) {
			System.out.println(coinValueUnit + COIN_VALUE_UNIT + HYPHEN
					+ vendingMachineCoinStatus.get(coinValueUnit) + COIN_COUNT_UNIT);
		}
	}

	public static void showInputMoneyStatus(int inputMoney) {
		System.out.println();
		System.out.println(INPUT_MONEY_STATUS + inputMoney + COIN_VALUE_UNIT);
	}

	public static void showChangeMoneyStatus(int lastMoneyValue,
			LinkedHashMap<Integer, Integer> changeCoinStatus) {
		System.out.println();
		System.out.println(INPUT_MONEY_STATUS + lastMoneyValue + COIN_VALUE_UNIT);
		System.out.println(CHANGE_MONEY_STATUS);
		changeCoinStatus.keySet().stream().filter(coin -> changeCoinStatus.get(coin) != 0)
				.forEach(coin -> System.out.println(
						coin + COIN_VALUE_UNIT + HYPHEN + changeCoinStatus.get(coin) + COIN_COUNT_UNIT));
	}
}
