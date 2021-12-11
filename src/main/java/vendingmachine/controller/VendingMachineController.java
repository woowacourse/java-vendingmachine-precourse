package vendingmachine.controller;

import static vendingmachine.utils.Validator.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;


import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	private final VendingMachine vendingMachine;
	private Products products = new Products();

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {

		int totalAmount = inputTotalAmountMoneyOfVendingMachine();
		vendingMachine.createChanges(totalAmount);
		printChangesVendingMachine(vendingMachine);

		String productInfo = inputInformationOfProducts();
		vendingMachine.createProductList(productInfo);

		String tempInputMoney = inputMoneyToPutInVendingMachine();
		vendingMachine.createInputMoney(Integer.parseInt(tempInputMoney));

		buyProducts();
		showRemainChanges();
	}

	public void buyProducts() {
		while (isValidToBuyProduct(vendingMachine)) {
			printCurrentInputMoney(vendingMachine);
			String productName = inputProductNameToBuy();
			vendingMachine.sellProduct(productName);
		}
	}

	public void showRemainChanges() {
		printCurrentInputMoney(vendingMachine);
		printRemainChanges(vendingMachine);
	}




}
