package vendingmachine.controller;

import static vendingmachine.utils.validator.InputMoneyValidator.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;


import java.util.List;

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
