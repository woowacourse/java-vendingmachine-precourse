package vendingmachine.controller;

import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private VendingMachineMoney vendingMachineMoney;

	public void start() {
		saveVendingMachineMoney();
		OutputView.printVendingMachineMoney(vendingMachineMoney.getCoins());
	}

	private void saveVendingMachineMoney() {
		int vendingMachineInputMoney = InputView.getVendingMachineMoney();
		vendingMachineMoney = new VendingMachineMoney(vendingMachineInputMoney);
		vendingMachineMoney.moneyToCoins();
		OutputView.printNewLine();
	}
}
