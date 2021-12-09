package vendingmachine.Controller;

import vendingmachine.Model.MoneyValidator;
import vendingmachine.Model.ProductValidator;
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

	public static String setProduct() {
		try {
			ProductValidator validation = new ProductValidator(InputView.machineProductInput());
			return validation.PRODUCT_STRING;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setProduct();
		}
	}
}
