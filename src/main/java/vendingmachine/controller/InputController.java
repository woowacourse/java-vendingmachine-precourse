package vendingmachine.controller;

import vendingmachine.util.Constants;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;

public class InputController {
	public void inputInitialValue() {
		inputVendingMachinePrice();
	}

	private void inputVendingMachinePrice() {
		String vendingMachinePrice;
		do {
			vendingMachinePrice = InputView.inputVendingMachinePrice();
		} while (!validateVendingMachinePrice(vendingMachinePrice));
	}

	private void handleInputError(boolean isValid, String errorMessage) {
		try {
			if (!isValid) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(errorMessage);
		}
	}

	private boolean validateVendingMachinePrice(String vendingMachinePrice) {
		boolean isValid = InputValidator.isEmptyString(vendingMachinePrice)
			&& InputValidator.isDigit(vendingMachinePrice)
			&& InputValidator.isGreaterThan(10, vendingMachinePrice)
			&& InputValidator.isDivided(10, vendingMachinePrice);
		handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_VENDING_MACHINE_PRICE);
		return isValid;
	}
}
