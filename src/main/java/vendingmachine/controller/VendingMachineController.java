package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;

public class VendingMachineController {

	private final VendingMachineService vendingMachineService = new VendingMachineService();

	public VendingMachine getVendingMachine() {
		return vendingMachineService.getVendingMachine();
	}

	public void inputVendingMachineChange() {
		String change;
		do {
			change = InputView.inputVendingMachineChange();
		} while (!vendingMachineService.validateVendingMachineChange(change));

		vendingMachineService.inputChangeAmount(change);
	}

	public void generateCoins() {
		vendingMachineService.generateCoins();
	}
}
