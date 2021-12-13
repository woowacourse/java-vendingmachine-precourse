package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.view.InputView;

public class VendingMachineController {
	public void run() {
		int machineMoney = InputView.getMachineMoney();
		Coin.generateRandomCount(machineMoney);
		for (Coin coin : Coin.values()) {
			System.out.println("coin = " + coin);
		}
	}
}
