package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine();

		initializeCoins(vendingMachine);
		OutputView.showCoins(vendingMachine);
		initializeItems(vendingMachine);
		initializeBalance(vendingMachine);

		while (vendingMachine.isAvailable()) {
			OutputView.showBalance(vendingMachine);
			executePurchase(vendingMachine);
		}
		OutputView.showBalance(vendingMachine);
		OutputView.showChanges(vendingMachine);
	}

	private void initializeCoins(VendingMachine vendingMachine) {
		String coinBalance = InputView.setCoins();
		try {
			vendingMachine.initializeCoins(coinBalance);
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			initializeCoins(vendingMachine);
		}
	}

	private void initializeItems(VendingMachine vendingMachine) {
		String items = InputView.setItems();
		try {
			vendingMachine.initializeItems(items);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			initializeItems(vendingMachine);
		}
	}

	private void initializeBalance(VendingMachine vendingMachine) {
		String balance = InputView.setBalance();
		try {
			vendingMachine.initializeBalance(balance);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			initializeBalance(vendingMachine);
		}
	}
}
