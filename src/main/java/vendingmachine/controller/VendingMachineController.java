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
		initInsertMoney();
		buyProducts();
		returnRemainChanges();
	}

	public void returnRemainChanges() {
		printCurrentInputMoney(vendingMachine);
		printRemainChanges(vendingMachine.returnChanges());

	}

	public void buyProducts() {
		while (checkIsValidToBuyProduct(vendingMachine)) {
			printCurrentInputMoney(vendingMachine);
			String productName = inputProductNameToBuy();
			if (checkIsValidToBuyProduct(vendingMachine, productName)) {
				vendingMachine.sellProduct(productName);
			}
		}
	}

	public void initInsertMoney() {
		while (true) {
			String insertMoney = insertMoneyIntoVendingMachine();
			if (checkIsValidInsertMoney(insertMoney)) {
				vendingMachine.createInsertMoney(Integer.parseInt(insertMoney));
				break;
			}
		}
	}

	public void initProductInfoList() {
		while (true) {
			List<String> productInfoList = inputInformationOfProducts();
			if (checkIsValidProductInfoList(productInfoList)) {
				vendingMachine.createProductList(productInfoList);
				break;
			}
		}
	}

	public void initAmountMoneyHoldingByVendingMachine() {
		while (true) {
			String amountMoney = inputTotalAmountOfVendingMachine();
			if (checkIsValidTotalAmount(amountMoney)) {
				vendingMachine.createChanges(Integer.parseInt(amountMoney));
				printChangesVendingMachine(vendingMachine);
				return;
			}
		}
	}

}
