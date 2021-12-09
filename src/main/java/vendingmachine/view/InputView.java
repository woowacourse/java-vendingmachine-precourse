package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.validator.MoneyValidator.*;
import static vendingmachine.validator.ProductValidator.*;
import static vendingmachine.view.OutputView.*;

public class InputView {

	public int getMoneyOfVendingMachine() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = readLine();
			try {
				isValid = isValidMoney(input);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return Integer.parseInt(input);
	}

	public int getDepositAmount() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = readLine();
			try {
				isValid = isValidDeposit(input);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return Integer.parseInt(input);
	}

	public String getProductsInput() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = readLine();
			try {
				isValid = isValidProducts(input);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return input;
	}

	public String getProductWantToBuy() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = readLine();
			try {
				isValid = isValidProductName(input);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return input;
	}

}
