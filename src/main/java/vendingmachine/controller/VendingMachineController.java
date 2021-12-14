package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine(inputHoldingAmountMoney());
		printHoldingAmountCoin(vendingMachine.getHoldingAmountCoinsToString());
		insertProductList(vendingMachine);
		vendingMachine.addInputAmount(inputMoney());
		purchaseIsPossible(vendingMachine);
		callPrintChangeAmount(vendingMachine);
	}

	private void insertProductList(VendingMachine vendingMachine) {
		try {
			vendingMachine.insertProductListInProductRepository(inputProductList());
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			insertProductList(vendingMachine);
		}
	}

	private void purchaseIsPossible(VendingMachine vendingMachine) {
		while (vendingMachine.isPossiblePurchase()) {
			purchaseProduct(vendingMachine);
		}
	}

	private void purchaseProduct(VendingMachine vendingMachine) {
		printInputAmount(vendingMachine.toString());
		try {
			vendingMachine.purchaseProduct(inputPurchaseProductName());
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			purchaseIsPossible(vendingMachine);
		}
	}

	private void callPrintChangeAmount(VendingMachine vendingMachine) {
		printInputAmount(vendingMachine.toString());
		printChangeAmount(vendingMachine.getChangeAmountToString());
	}
}
