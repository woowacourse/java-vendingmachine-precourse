package vendingmachine.controller;

import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.InputView;

public class VendingMachineController {
	private VendingMachineMoney vendingMachineMoney;

	public void start() {
		saveVendingMachineMoney();
	}

	private void saveVendingMachineMoney() {
		int vendingMachineInputMoney = InputView.getVendingMachineMoney();
		vendingMachineMoney = new VendingMachineMoney(vendingMachineInputMoney);
		vendingMachineMoney.moneyToCoins();
	}
}
