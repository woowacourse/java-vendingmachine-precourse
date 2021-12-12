package vendingmachine.Controller;

import vendingmachine.Model.BeverageGroup;
import vendingmachine.Model.Money;
import vendingmachine.Model.VendingMachine;
import vendingmachine.Utils.Validator.NameValidator;
import vendingmachine.Utils.Validator.SellValidator;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class InputController {
	public static Money getMachineMoney() {
		try {
			return new Money(InputView.machineMoneyInput());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMachineMoney();
		}
	}

	public static Money getUserMoney() {
		try {
			return new Money(InputView.userMoneyInput());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getUserMoney();
		}
	}

	public static BeverageGroup getBeverageGroup() {
		try {
			return new BeverageGroup(InputView.beverageGroupInput());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getBeverageGroup();
		}
	}

	public static String getBeverageName(VendingMachine vendingMachine) {
		try {
			String input = InputView.beverageNameInput();
			new NameValidator(input);
			new SellValidator(vendingMachine.getBeverage(input), vendingMachine.getUserMoney());
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getBeverageName(vendingMachine);
		}
	}
}
