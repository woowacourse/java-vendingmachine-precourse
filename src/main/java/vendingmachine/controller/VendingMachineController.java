package vendingmachine.controller;

import vendingmachine.model.CoinList;
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

	private void sell(String productName) {
		ProductList productList = vendingMachine.getProductList();

		productList.subtractQuantity(productName);

		int price = productList.getPrice(productName);
		vendingMachine.subtractDeposit(price);
	}

}
