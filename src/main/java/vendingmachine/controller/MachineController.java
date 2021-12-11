package vendingmachine.controller;

import vendingmachine.util.Constant;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
	private static int inputAmount;
	public static void runMachine() {
		int holdingAmount = askHoldingAmount();
		OutputView.showHoldingCoins(holdingAmount);
		askProductInfo();
		inputAmount = askInputAmount();
		purchase();
		OutputView.showChanges(inputAmount);
	}
	private static int askHoldingAmount() {
		try {
			return InputView.askHoldingAmount();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return askHoldingAmount();
	}

	private static void askProductInfo() {
		System.out.println();
		try {
			InputView.askProductInfo();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			askProductInfo();
		}
	}

	private static int askInputAmount() {
		try {
			System.out.println();
			return InputView.askInputAmount();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return askInputAmount();
	}

	private static int askPurchase() {
		try {
			System.out.println();
			OutputView.showInputAmount(inputAmount);
			return InputView.askPurchase();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return askPurchase();
	}

	private static void purchase() {
		while (!(InputView.isEmpty()) && InputView.getMinPrice() <= inputAmount) {
			inputAmount -= askPurchase();
		}
	}
}
