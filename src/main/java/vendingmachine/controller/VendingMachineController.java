package vendingmachine.controller;

import vendingmachine.validator.Validator;
import vendingmachine.view.Input;

public class VendingMachineController {
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
