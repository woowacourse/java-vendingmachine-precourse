package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final Products products;
	private final Changes changes;
	private VendingMachine vendingMachine;

	public VendingMachineController() {
		this.changes = initChanges();
		OutputView.printVendingmachineChanges(changes);
		this.products = initProducts();
		this.vendingMachine = initVendingMachine();
	}

	public void run() {
		while (!products.hasNotProductsCount() &&
			products.canBuyCurrentAmount(vendingMachine.getCurrentAmount())) {
			OutputView.printCurrentMoney(vendingMachine.getCurrentAmount());
			initBuyProduct();
		}
		OutputView.printCurrentMoney(vendingMachine.getCurrentAmount());
		OutputView.printChanges(changes.giveChanges(vendingMachine.getCurrentAmount()));
	}

	private void initBuyProduct() {
		try {
			products.buyProduct(InputView.inputBuyProduct(), vendingMachine);
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

	private VendingMachine initVendingMachine() {
		try {
			String inputAmount = InputView.inputAmount();
			return new VendingMachine(inputAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return initVendingMachine();
		}
	}
}
