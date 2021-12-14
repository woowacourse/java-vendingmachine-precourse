package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		int machineMoney = InputView.getMachineMoney();
		Coin.generateRandomCount(machineMoney);
		OutputView.printMachineCoins();
	}
}
