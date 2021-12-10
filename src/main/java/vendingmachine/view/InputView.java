package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.validator.BuyValidator.*;
import static vendingmachine.validator.MoneyValidator.*;
import static vendingmachine.validator.ProductValidator.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.model.VendingMachine;

public class InputView {

	public int getValidMoney() {
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

	public String getRawProductsInput() {
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

	public String getProductWantToBuy(VendingMachine vendingMachine) {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = readLine();
			try {
				isValid = isAvailableForBuy(input, vendingMachine);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return input;
	}

}
