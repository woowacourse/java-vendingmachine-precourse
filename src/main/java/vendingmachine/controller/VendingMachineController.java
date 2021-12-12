package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;

public class VendingMachineController {

	private static final VendingMachineService vendingMachineService = new VendingMachineService();

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

	public void inputUserInputAmount() {
		String inputAmount;
		do {
			inputAmount = InputView.inputUserInputAmount();
		} while (!vendingMachineService.validateInputAmount(inputAmount));
		vendingMachineService.inputUserInputAmount(inputAmount);
	}

}
