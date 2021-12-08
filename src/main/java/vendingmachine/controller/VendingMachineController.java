package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingMachineController {
	private int vendingMachineMoney;

	public void start() {
		saveVendingMachineMoney();
	}

	private void saveVendingMachineMoney() {
		vendingMachineMoney = InputView.getVendingMachineMoney();
	}
}
