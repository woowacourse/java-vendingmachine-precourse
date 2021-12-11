package vendingmachine.Controller;

import vendingmachine.Model.VendingMachine;
import vendingmachine.Utils.Validator.BeverageValidator;
import vendingmachine.Utils.Validator.MoneyValidator;
import vendingmachine.Utils.Validator.NameValidator;
import vendingmachine.Utils.Validator.SellValidator;
import vendingmachine.View.InputView;

public class InputController {
	public static String getMachineMoney() {
		try {
			String input = InputView.machineMoneyInput();
			new MoneyValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMachineMoney();
		}
	}

	public static String getUserMoney() {
		try {
			String input = InputView.userMoneyInput();
			new MoneyValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMachineMoney();
		}
	}

	public static String getBeverages() {
		try {
			String input = InputView.machinebeverageInput();
			new BeverageValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBeverages();
		}
	}

	public static String getBeverageName(VendingMachine vendingMachine) {
		try {
			String input = InputView.buybeverageNameInput();
			new NameValidator(input, vendingMachine.getNames());
			new SellValidator(vendingMachine.getBeverage(input), vendingMachine.getUserMoney());
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBeverageName(vendingMachine);
		}
	}
}
