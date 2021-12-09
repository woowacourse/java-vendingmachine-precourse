package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.BalanceValidator;

public class BalanceController {

	public static int getInputValue() {
		String inputString = Console.readLine();

		try {
			BalanceValidator.validate(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getInputValue();
		}
		return Integer.parseInt(inputString);
	}
}
