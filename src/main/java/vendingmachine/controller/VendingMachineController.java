package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Products;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final Products products;
	private final Changes changes;
	private Money money;

	public VendingMachineController() {
		this.changes = initChanges();
		OutputView.printVendingmachineChanges(changes);
		this.products = initProducts();
		this.money = initVendingMachine();
	}

	public void run() {
		while (!products.hasNotProductsCount() &&
			products.canBuyCurrentAmount(money.getCurrentAmount())) {
			OutputView.printCurrentMoney(money.getCurrentAmount());
			initBuyProduct();
		}
			OutputView.printCurrentMoney(money.getCurrentAmount());
			OutputView.printChanges(changes.giveChanges(money.getCurrentAmount()));
	}

	private void initBuyProduct() {
		try {
			products.buyProduct(InputView.inputBuyProduct(), money);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			initBuyProduct();
		}
	}

	private Changes initChanges() {
		try {
			String haveAmount = InputView.haveAmount();
			return new Changes(haveAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return initChanges();
		}
	}

	private Products initProducts() {
		try {
			String inputProduts = InputView.inputProducts();
			return new Products(inputProduts);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return initProducts();
		}
	}

	private Money initVendingMachine() {
		try {
			String inputAmount = InputView.inputAmount();
			return new Money(inputAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return initVendingMachine();
		}
	}
}
