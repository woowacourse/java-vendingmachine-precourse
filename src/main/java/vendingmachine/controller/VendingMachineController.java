package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.validator.Validator;
import vendingmachine.view.Input;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public VendingMachineController() {
		Coins coins = new Coins(getMoneyInMachine());
		Products products = ProductsController.getProducts();
		int inputMoney = getInputMoney();
		vendingMachine = new VendingMachine(coins, products, inputMoney);
	}

	public void run() {
		while(vendingMachine.checkTermination()) {
			vendingMachine.buy(getBuyingProductName());
		}
		// 잔돈반환
	}

	private static int getMoneyInMachine() {
		int moneyInMachine;
		do {
			moneyInMachine = Input.moneyInMachine();
		} while (Validator.isValidMoneyInMachine(moneyInMachine));
		return moneyInMachine;
	}

	private static int getInputMoney() {
		int inputMoney;
		do {
			inputMoney = Input.inputMoney();
		} while (Validator.isValidInputMoney(inputMoney));
		return inputMoney;
	}

	private static String getBuyingProductName() {
		return Input.buyingProductName();
	}
}
