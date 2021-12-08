package vendingmachine.view;

import static vendingmachine.validator.MoneyValidator.*;
import static vendingmachine.view.OutputView.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public int getMoneyOfVendingMachine() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = Console.readLine();
			try {
				isValid = isValidMoney(input);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return Integer.parseInt(input);
	}

}
