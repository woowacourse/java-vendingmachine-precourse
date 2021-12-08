package vendingmachine.Controller;

import vendingmachine.Model.MoneyValidator;
import vendingmachine.View.InputView;

public class InputController {

	public static int setMoney() {
		try {
			MoneyValidator validation = new MoneyValidator(InputView.machineMoneyInput());
			return validation.MONEY;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setMoney();
		}
	}
}
