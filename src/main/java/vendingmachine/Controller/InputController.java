package vendingmachine.Controller;

import vendingmachine.Model.VendingMachine;
import vendingmachine.Utils.Validator.MoneyValidator;
import vendingmachine.Utils.Validator.NameValidator;
import vendingmachine.Utils.Validator.ProductValidator;
import vendingmachine.Utils.Validator.SellValidator;
import vendingmachine.View.InputView;

public class InputController {
	public static String getMachineMoneyInput() {
		try {
			String input = InputView.machineMoneyInput();
			new MoneyValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMachineMoneyInput();
		}
	}

	public static String getUserMoneyInput() {
		try {
			String input = InputView.userMoneyInput();
			new MoneyValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMachineMoneyInput();
		}
	}

	public static String getProductsInput() {
		try {
			String input = InputView.machineProductInput();
			new ProductValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getProductsInput();
		}
	}

	public static String getProductNameInput(VendingMachine vendingMachine) {
		try {
			String input = InputView.buyProductNameInput();
			new NameValidator(input, vendingMachine.products.getNames());
			new SellValidator(vendingMachine.products.getProduct(input), vendingMachine.userMoney);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getProductNameInput(vendingMachine);
		}
	}
}
