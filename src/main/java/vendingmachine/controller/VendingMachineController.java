package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.validator.Validator;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class VendingMachineController {
	private static VendingMachine vendingMachine;

	public VendingMachineController() {
		Coins coins = new Coins(getMoneyInMachine());
		Output.coinsInMachine(coins);
		Products products = ProductsController.getProducts();
		int inputMoney = getInputMoney();
		vendingMachine = new VendingMachine(coins, products, inputMoney);
	}

	private static int getMoneyInMachine() {
		int moneyInMachine;
		do {
			moneyInMachine = Input.moneyInMachine();
		} while (!Validator.isValidMoneyInMachine(moneyInMachine));
		return moneyInMachine;
	}

	private static int getInputMoney() {
		int inputMoney;
		do {
			inputMoney = Input.inputMoney();
		} while (!Validator.isValidInputMoney(inputMoney));
		return inputMoney;
	}

	private static String getBuyingProductName() {
		return Input.buyingProductName();
	}

	public static void run() {
		while (!vendingMachine.checkTermination()) {
			try {
				Output.inputMoney(vendingMachine.getInputMoney());
				vendingMachine.buy(getBuyingProductName());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		Output.inputMoney(vendingMachine.getInputMoney());
		Output.change(vendingMachine.giveChange());
	}
}
