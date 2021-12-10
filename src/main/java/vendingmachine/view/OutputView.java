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
		System.out.println(ENTER_PRODUCT_AND_NUMBER);
	}

	public static void enterInputMoney() {
		System.out.println(ENTER_INPUT_MONEY);
	}

	public static void showRemainingMoney(int money) {
		System.out.println(INPUT_MONEY + money + WON);
	}

	public static void enterWantProduct() {
		System.out.println(ENTER_WANT_TO_BUY_PRODUCT);
	}

	public static void showRemainingMoney(LinkedHashMap<Integer, Integer> coins) {
		System.out.println(REMAINING_MONEY);
		coins.entrySet().stream()
			.filter(key -> key.getValue() > 0)
			.forEach(key -> System.out.println(key + RULES_TO_SHOW + NUMBER));
	}
}
