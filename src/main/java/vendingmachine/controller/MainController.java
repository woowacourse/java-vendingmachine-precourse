package vendingmachine.controller;

import vendingmachine.view.OutputView;

public class MainController {
	public void run() {
		VendingMachineController vendingMachineController = new VendingMachineController();
		ProductController productController = new ProductController();
		PurchaseController purchaseController = new PurchaseController(productController.getProductService());

		vendingMachineController.inputVendingMachineChange();
		vendingMachineController.generateCoins();
		OutputView.printCoins(vendingMachineController.getVendingMachine());

		productController.inputProduct();

		purchaseController.inputUserInputAmount();
		purchaseController.buy();
		vendingMachineController.returnChange(purchaseController.getFinalUserInputAmount());
	}
}
