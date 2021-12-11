package vendingmachine.view;

import java.util.LinkedHashMap;

public class OutputView {
	public static String VENDING_MACHINE_HAVING_COIN_STATUS = "자판기가 보유한 동전";
	public static String COIN_VALUE_UNIT = "원";
	public static String COIN_COUNT_UNIT = "개";
	public static String HYPHEN = " - ";
	public static String INPUT_MONEY_STATUS = "투입 금액: ";
	public static String CHANGE_MONEY_STATUS = "잔돈";

	public static void showVendingMahcineCoinStatus(LinkedHashMap<Integer, Integer> vendingMachineCoinStatus) {
		System.out.println();
		System.out.println(VENDING_MACHINE_HAVING_COIN_STATUS);
		for (Integer coinValueUnit : vendingMachineCoinStatus.keySet()) {
			System.out.println(coinValueUnit + COIN_VALUE_UNIT + HYPHEN + vendingMachineCoinStatus.get(coinValueUnit) + COIN_COUNT_UNIT);
		}
	}

	public static void showInputMoneyStatus(int inputMoney) {
		System.out.println();
		System.out.println(INPUT_MONEY_STATUS + inputMoney + COIN_VALUE_UNIT);
	}

	public static void showChangeMoneyStatus(int lastMoneyValue, LinkedHashMap<Integer, Integer> changeCoinStatus) {
		System.out.println();
		System.out.println(INPUT_MONEY_STATUS + lastMoneyValue +COIN_VALUE_UNIT);
		System.out.println(CHANGE_MONEY_STATUS);
		for (Integer coinValueUnit : changeCoinStatus.keySet()) {
			if (changeCoinStatus.get(coinValueUnit) != 0) {
				System.out.println(coinValueUnit + COIN_VALUE_UNIT + HYPHEN + changeCoinStatus.get(coinValueUnit) + COIN_COUNT_UNIT);
			}
		}
	}
}
