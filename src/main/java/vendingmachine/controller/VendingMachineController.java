package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readLineInt());
		showVendingMachineCoins();
	}

	private void showVendingMachineCoins() {
		OutputView.showCoins(vendingMachine.getCoinsOwned());
	}

	public void addProduct() {
		OutputView.addProductAndNumbers();
		vendingMachine.addProduct(InputView.readLineString());
	}
}