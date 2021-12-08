package vendingmachine.view;

import static constants.VendingMachineConstants.*;

import java.util.List;

import vendingmachine.domain.Coin;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}

	public static void printVendingMachineMoney(List<Coin> coins) {
		System.out.println(VENDING_MACHINE_MONEY_OUTPUT_MESSAGE);
		for (Coin coin : coins) {
			System.out.println(coin);
		}
	}

	public static void printNewLine() {
		System.out.println();
	}
}
