package vendingmachine.view;

import static constants.VendingMachineConstants.*;

import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.User;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}

	public static void printVendingMachineMoney(Map<Coin, Integer> coins) {
		System.out.println(VENDING_MACHINE_MONEY_OUTPUT_MESSAGE);
		for (Coin coin : coins.keySet()) {
			System.out.print(coin);
			System.out.println(coins.get(coin) + KOR_ITEM_UNIT);
		}
		printNewLine();
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printUserInputMoney(User user) {
		System.out.println(user);
	}
}
