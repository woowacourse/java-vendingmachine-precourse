package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.RandomGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	public static void run() {
		Coins coins = new Coins(
			RandomGenerator.getHoldingCoin((InputView.getHoldingAmount()))
		);
		OutputView.inputHoldingCoin(coins.getHoldingCoin());
		InputView.getProducts();
		VendingMachine vendingMachine = new VendingMachine(InputView.getEnteredAmount());
	}
}
