package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;


import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final VendingMachine vendingMachine;
	private Products products = new Products();

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		printMessageToGetAmountMoneyOfVendingMachine();
		int totalChanges = inputTotalAmountMoneyOfVendingMachine();
		vendingMachine.createChanges(totalChanges);
		printChangesVendingMachine(vendingMachine);

		printMessageToGetInformationOfProducts();
		String productInfo = inputInformationOfProducts();
		vendingMachine.createProductList(productInfo);

		printMessageToGetInputMoney();
		String tempInputMoney = inputMoneyToPutInVendingMachine();
		vendingMachine.createInputMoney(Integer.parseInt(tempInputMoney));
		printCurrentInputMoney(vendingMachine);

		printMessageToGetProductNameToBuy();
		String productName = inputProductNameToBuy();
		vendingMachine.sellProduct(productName);
	}
}
