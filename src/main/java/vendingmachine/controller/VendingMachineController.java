package vendingmachine.controller;

import static vendingmachine.utils.validator.MoneyValidator.*;
import static vendingmachine.utils.validator.ProductValidator.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;


import java.util.List;

import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		initAmountMoneyHoldingByVendingMachine();
		initProductInfoList();

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

	public void initProductInfoList() {
		List<String> productInfoList = inputInformationOfProducts();
		if (checkIsValidProductInfoList(productInfoList)) {
			vendingMachine.createProductList(productInfoList);
			return;
		}
		initProductInfoList();
	}

	public void initAmountMoneyHoldingByVendingMachine() {
		String amountMoney = inputTotalAmountOfVendingMachine();
		if (checkIsValidTotalAmount(amountMoney)) {
			vendingMachine.createChanges(Integer.parseInt(amountMoney));
			printChangesVendingMachine(vendingMachine);
			return;
		}
		initAmountMoneyHoldingByVendingMachine();
	}

}
