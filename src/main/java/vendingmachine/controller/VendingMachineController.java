package vendingmachine.controller;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine();

		initializeChanges(vendingMachine);
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
}
