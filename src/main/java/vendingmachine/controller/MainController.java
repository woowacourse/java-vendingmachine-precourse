package vendingmachine.controller;

import vendingmachine.view.OutputView;

public class MainController {
	public void run() {
		VendingMachineController vendingMachineController = new VendingMachineController();

		vendingMachineController.inputVendingMachineChange();
		vendingMachineController.generateCoins();

		OutputView.printCoins();

		ProductController productController = new ProductController();
		productController.inputProduct();

		vendingMachineController.inputUserInputAmount();
	}
}
