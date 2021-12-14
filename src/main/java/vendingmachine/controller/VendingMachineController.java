package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.validator.Validator;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class VendingMachineController {
	private final VendingMachine vendingMachine;

	public VendingMachineController() {
		Coins coins = new Coins(getValidMoneyInMachine());
		Output.coinsInMachine(coins);
		Products products = ProductsController.getProducts();
		int inputMoney = getValidInputMoney();
		vendingMachine = new VendingMachine(coins, products, inputMoney);
	}

	private static int getValidMoneyInMachine() {
		int moneyInMachine;
		do {
			moneyInMachine = Input.moneyInMachine();
		} while (!Validator.isValidMoneyInMachine(moneyInMachine));
		return moneyInMachine;
	}

	private static int getValidInputMoney() {
		int inputMoney;
		do {
			inputMoney = Input.inputMoney();
		} while (!Validator.isValidInputMoney(inputMoney));
		return inputMoney;
	}
	
	public void run() {
		while (!vendingMachine.checkTermination()) {
			runBuyingProduct();
		}
		Output.inputMoney(vendingMachine.getInputMoney());
		Output.change(vendingMachine.giveChange());
	}

	private void runBuyingProduct() {
		try {
			Output.inputMoney(vendingMachine.getInputMoney());
			vendingMachine.buy(Input.buyingProductName());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
