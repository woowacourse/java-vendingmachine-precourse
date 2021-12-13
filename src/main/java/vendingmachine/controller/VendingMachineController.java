package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.validator.Validator;
import vendingmachine.view.Input;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public VendingMachineController() {
		Coins coins = getCoins(getMoneyInMachine());
		Products products = ProductsController.getProducts();
		int inputMoney = getInputMoney();
		vendingMachine = new VendingMachine(coins, products, inputMoney);
	}

	private static Coins getCoins(int moneyInMachine) {
		Coins coins = new Coins(moneyInMachine);
		coins.makeRandomNumberOfCoins();
		return coins;
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
