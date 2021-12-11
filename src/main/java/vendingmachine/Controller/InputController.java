package vendingmachine.Controller;

import vendingmachine.Model.VendingMachine;
import vendingmachine.Utils.Validator.MoneyValidator;
import vendingmachine.Utils.Validator.NameValidator;
import vendingmachine.Utils.Validator.ProductValidator;
import vendingmachine.Utils.Validator.SellValidator;
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

	public static String setWantedProduct(VendingMachine vendingMachine) {
		try {
			String name = InputView.buyProductNameInput();
			new NameValidator(name, vendingMachine.productList.getNames());
			new SellValidator(vendingMachine.productList.find(name), vendingMachine.userMoney);
			return name;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setWantedProduct(vendingMachine);
		}
	}
}
