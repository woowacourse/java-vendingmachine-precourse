package vendingmachine.view;

import java.util.LinkedHashMap;

public class OutputView {
	public static String VENDING_MACHINE_HAVING_COIN_STATUS = "자판기가 보유한 동전";
	public static String COIN_VALUE_UNIT = "원";
	public static String COIN_COUNT_UNIT = "개";
	public static String HYPHEN = " - ";

	public static void showVendingMahcineCoinStatus(LinkedHashMap<Integer, Integer> vendingMachineCoinStatus) {
		for (Integer coinValueUnit : vendingMachineCoinStatus.keySet()) {
			System.out.println(coinValueUnit + COIN_VALUE_UNIT + HYPHEN + vendingMachineCoinStatus.get(coinValueUnit) + COIN_COUNT_UNIT);
		}
	}
}
