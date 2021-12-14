package vendingmachine.controller;

import static vendingmachine.view.OutputView.*;

import vendingmachine.model.VendingMachine;
import vendingmachine.validator.BuyValidator;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.validator.ProductValidator;
import vendingmachine.view.InputView;

public class ViewController {

	public static InputView inputView = new InputView();

	public int returnMoneyOfVendingMachine() {
		try {
			String input = inputView.getMoneyInput();
			MoneyValidator.isValidMoney(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException exception) {
			printError(exception);
			return returnMoneyOfVendingMachine();
		}
	}

	public int returnDepositAmount() {
		try {
			String input = inputView.getDepositInput();
			MoneyValidator.isValidMoney(input);

			int deposit = Integer.parseInt(input);
			printRemainingDeposit(deposit);

			return deposit;
		} catch (IllegalArgumentException exception) {
			printError(exception);
			return returnDepositAmount();
		}
	}

	public String returnRawProductsInput() {
		try {
			String input = inputView.getRawProductsInput();
			ProductValidator.isValidProducts(input);
			return input;
		} catch (IllegalArgumentException exception) {
			printError(exception);
			return returnRawProductsInput();
		}
	}

	public String returnProductWantToBuy(VendingMachine vendingMachine) {
		try {
			String input = inputView.getProductWantToBuy();
			BuyValidator.isAvailableForBuy(input, vendingMachine);
			return input;
		} catch (IllegalArgumentException exception) {
			printError(exception);
			return returnProductWantToBuy(vendingMachine);
		}
	}

}
