package vendingmachine.controller;

import vendingmachine.model.Changes;
import vendingmachine.model.Coins;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;

public class VendingMachineController {

	private final ViewController viewController;
	private VendingMachine vendingMachine;

	public VendingMachineController(ViewController viewController) {
		this.viewController = viewController;
	}

	public void init() {
		int moneyOfVendingMachine = viewController.returnMoneyOfVendingMachine();
		Coins coins = new Coins(moneyOfVendingMachine);
		coins.init();

		Products products = new Products();
		String rawProductsInput = viewController.returnRawProductsInput();
		products.init(rawProductsInput);

		int deposit = viewController.returnDepositAmount();

		this.vendingMachine = new VendingMachine(deposit, products, coins);
	}

	public void run() {
		while (vendingMachine.isContinueToSell()) {
			String productName = viewController.returnProductWantToBuy(vendingMachine);
			sell(productName);

			int remainingDeposit = vendingMachine.getDeposit();
			viewController.printRemainingDeposit(remainingDeposit);
		}

		returnChanges();
	}

	private void sell(String productName) {
		Products products = vendingMachine.getProductList();

		Product product = products.findProduct(productName);
		product.subtractQuantity();

		int price = product.getPrice();
		vendingMachine.subtractDeposit(price);
	}

	private void returnChanges() {
		Changes changes = vendingMachine.createChanges();
		System.out.println(changes);
	}

}
