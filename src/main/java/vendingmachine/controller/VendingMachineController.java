package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
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
			inputMoney = Input.moneyInMachine();
		} while (Validator.isValidInputMoney(inputMoney));
		return inputMoney;
	}
}
