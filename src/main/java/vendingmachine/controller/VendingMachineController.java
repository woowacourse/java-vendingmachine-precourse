package vendingmachine.controller;

import static vendingmachine.utils.message.SystemMessage.*;
import static vendingmachine.utils.validator.MoneyValidator.*;
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
		returnRemainChanges();
	}

	public void buyProducts() {
		while (isValidToBuyProduct(vendingMachine)) {
			printCurrentInputMoney(vendingMachine);
			String productName = inputProductNameToBuy(vendingMachine);
			vendingMachine.sellProduct(productName);
		}
	}

	public void returnRemainChanges() {
		printCurrentInputMoney(vendingMachine);
		printRemainChanges(vendingMachine.returnChanges());

	}

}
