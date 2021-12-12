package vendingmachine;

import vendingmachine.controller.VendingMachine;

public class Application {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.initHoldingMoney();
		vendingMachine.showAllCoinQuantity();
		vendingMachine.registerProducts();
		vendingMachine.sellProduct();
	}
}
