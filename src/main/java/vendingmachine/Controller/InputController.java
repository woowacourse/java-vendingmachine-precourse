package vendingmachine.Controller;

import vendingmachine.Model.VendingMachine;
import vendingmachine.Utils.Validator.MoneyValidator;
import vendingmachine.Utils.Validator.NameValidator;
import vendingmachine.Utils.Validator.ProductValidator;
import vendingmachine.Utils.Validator.SellValidator;
import vendingmachine.View.InputView;

public class InputController {
	public static String initMachineMoney() {
		try {
			String input = InputView.machineMoneyInput();
			new MoneyValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return initMachineMoney();
		}
	}

	public static String setUserMoney() {
		try {
			String input = InputView.userMoneyInput();
			new MoneyValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return initMachineMoney();
		}
	}

	public static String setProducts() {
		try {
			String input = InputView.machineProductInput();
			new ProductValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setProducts();
		}
	}

	public static String setWantedProduct(VendingMachine vendingMachine) {
		try {
			String input = InputView.buyProductNameInput();
			new NameValidator(input, vendingMachine.productList.getNames());
			new SellValidator(vendingMachine.productList.find(input), vendingMachine.userMoney);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setWantedProduct(vendingMachine);
		}
	}
}
