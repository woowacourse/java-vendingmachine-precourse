package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine(inputHoldingAmountMoney());
		printHoldingAmountCoin(vendingMachine.getHoldingAmountCoins());
		vendingMachine.insertProductListInProductRepository(inputProductList());
		vendingMachine.insertUserInputAmount(inputUserAmount());
		purchaseIsPossible(vendingMachine);
	}

	private void purchaseIsPossible(VendingMachine vendingMachine) {
		while (vendingMachine.isPossibleRepurchase()) {
			purchaseProduct(vendingMachine);
		}
	}

	private void purchaseProduct(VendingMachine vendingMachine) {
		printInputAmount(vendingMachine.getInputAmount());
		vendingMachine.purchaseProduct(inputPurchaseProductName());
	}

}
