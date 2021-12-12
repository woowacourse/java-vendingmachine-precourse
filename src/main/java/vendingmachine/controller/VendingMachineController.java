package vendingmachine.controller;

import static vendingmachine.utils.validator.TotalAmountValidator.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;


import java.util.List;

import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	private final VendingMachine vendingMachine;
	private final Products products = new Products();

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		vendingMachine.createChanges(inputTotalAmountOfVendingMachine());
		printChangesVendingMachine(vendingMachine);

		List<String> productInfoList = inputInformationOfProducts();
		vendingMachine.createProductList(productInfoList);

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
