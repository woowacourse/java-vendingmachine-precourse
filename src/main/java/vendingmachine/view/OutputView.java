package vendingmachine.view;

import static constants.VendingMachineConstants.*;

import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.User;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}

	public static void printVendingMachineMoney(List<Coin> coins) {
		System.out.println(VENDING_MACHINE_MONEY_OUTPUT_MESSAGE);
		for (Coin coin : coins) {
			System.out.println(coin);
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
