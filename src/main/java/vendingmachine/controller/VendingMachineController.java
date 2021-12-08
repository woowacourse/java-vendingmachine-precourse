package vendingmachine.controller;

import static vendingmachine.app.ObjectContainer.*;

import vendingmachine.view.InputView;

public class VendingMachineController {
	public void startVendingMachine() {
		String vendingMachineBalance = InputView.getVendingMachineBalance();
		saveBalance(vendingMachineBalance);
	}

	private void saveBalance(String balance) {
		try {
			vendingMachine.setBalance(balance);
			saveCoins();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + "\n");
			startVendingMachine();
		}
	}

	private void saveCoins() {
		vendingMachine.setCoins();
	}

}
