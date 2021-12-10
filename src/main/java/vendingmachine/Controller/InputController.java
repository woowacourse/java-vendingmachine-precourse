package vendingmachine.Controller;

import vendingmachine.Model.Validator.MoneyValidator;
import vendingmachine.Model.Validator.NameValidator;
import vendingmachine.Model.Validator.ProductValidator;
import vendingmachine.Model.Validator.SellValidator;
import vendingmachine.View.InputView;

public class InputController {
	public static int setMachineMoney() {
		try {
			MoneyValidator validation = new MoneyValidator(InputView.machineMoneyInput());
			return validation.MONEY;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setMachineMoney();
		}
	}

	public static int setUserMoney() {
		try {
			MoneyValidator validation = new MoneyValidator(InputView.userMoneyInput());
			return validation.MONEY;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setMachineMoney();
		}
	}

	public static String setProducts() {
		try {
			ProductValidator validation = new ProductValidator(InputView.machineProductInput());
			return validation.PRODUCT_STRING;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setProducts();
		}
	}

	public static String setWantedProduct(String[] names) {
		try {
			String name = InputView.buyProductNameInput();
			new NameValidator(name, names);
			new SellValidator(name);
			return name;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setWantedProduct(names);
		}
	}
}
