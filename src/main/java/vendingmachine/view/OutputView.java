package vendingmachine.view;

import static vendingmachine.constant.Constant.*;

import java.util.LinkedHashMap;

public class OutputView {
	public static void setVendingMachineMoney() {
		System.out.println(ENTER_VENDING_MACHINE_INITIAL_MONEY);
	}

	public static void showCoins(LinkedHashMap<Integer, Integer> coins) {
		System.out.println(VENDING_MACHINE_COINS);
		for (int coin : coins.keySet()) {
			System.out.println(coin + RULES_TO_SHOW + coins.get(coin) + NUMBER);
		}
		System.out.println();
	}

	public static void addProductAndNumbers() {
		System.out.println(ENTER_PRODUCT_AND_NUMBER_MESSAGE);
	}
}
