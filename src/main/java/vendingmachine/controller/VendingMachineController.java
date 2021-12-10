package vendingmachine.controller;

import vendingmachine.model.Changes;
import vendingmachine.model.CoinList;
import vendingmachine.model.Product;
import vendingmachine.model.ProductList;
import vendingmachine.model.VendingMachine;

public class VendingMachineController {

	private final ViewController viewController;
	private VendingMachine vendingMachine;

	public VendingMachineController(ViewController viewController) {
		this.viewController = viewController;
	}

	public void init() {
		int moneyOfVendingMachine = viewController.returnMoneyOfVendingMachine();
		CoinList coinList = new CoinList(moneyOfVendingMachine);
		coinList.init();

		ProductList productList = new ProductList();
		String productListRawInput = viewController.returnProductList();
		productList.init(productListRawInput);

		int deposit = viewController.returnDepositAmount();

		this.vendingMachine = new VendingMachine(deposit, productList, coinList);
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
		ProductList productList = vendingMachine.getProductList();

		Product product = productList.findProduct(productName);
		product.subtractQuantity();

		int price = product.getPrice();
		vendingMachine.subtractDeposit(price);
	}

	private void returnChanges() {
		Changes changes = vendingMachine.createChanges();
		System.out.println(changes);
	}

}
