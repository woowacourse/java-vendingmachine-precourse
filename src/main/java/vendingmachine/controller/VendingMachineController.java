package vendingmachine.controller;

import static vendingmachine.view.InputView.*;


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
		OutputView.printChangesVendingMachine(vendingMachine);

		printMessageToGetInformationOfProducts();
		String informationOfProducts = inputInformationOfProducts();
		products.createProductList(informationOfProducts);

		printMessageToGetInputMoney();
		String inputMoney = inputMoneyToPutInVendingMachine();

	}
}
