package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingMachineController {
	private int vendingMachineInputMoney;

	public void start() {
		saveVendingMachineMoney();
	}

	private void saveVendingMachineMoney() {
		vendingMachineInputMoney = InputView.getVendingMachineMoney();
	}
}
