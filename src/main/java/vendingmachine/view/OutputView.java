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
		printCoins(coins);
		printNewLine();
	}

	public static void printChanges(Map<Coin, Integer> coins) {
		System.out.println(CHANGES_MESSAGE);
		if (coins.isEmpty()) {
			System.out.println(HAVE_NO_CHANGE_MESSAGE);
		}
		printCoins(coins);
	}

	public static void printCoins(Map<Coin, Integer> coins) {
		for (Coin coin : coins.keySet()) {
			System.out.print(coin);
			System.out.println(coins.get(coin) + KOR_ITEM_UNIT);
		}
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printUserInputMoney(User user) {
		System.out.println(user);
	}
}
