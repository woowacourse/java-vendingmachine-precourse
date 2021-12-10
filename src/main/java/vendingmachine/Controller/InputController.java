package vendingmachine.Controller;

import vendingmachine.Model.Validator.MoneyValidator;
import vendingmachine.Model.Validator.NameValidator;
import vendingmachine.Model.Validator.ProductValidator;
import vendingmachine.Model.Validator.SellValidator;
import vendingmachine.View.InputView;

public class InputController {

	public static int setMachineMoney() {
		int machineMoney;
		do {
			machineMoney = setMoney(InputView.machineMoneyInput());
		} while (machineMoney == -1);
		return machineMoney;
	}

	public static int setUserMoney() {
		int userMoney;
		do {
			userMoney = setMoney(InputView.userMoneyInput());
		} while (userMoney == -1);
		return userMoney;
	}

	public static int setMoney(String money) {
		try {
			MoneyValidator validation = new MoneyValidator(money);
			return validation.MONEY;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return -1;
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
