package vendingmachine.service;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Constants;
import vendingmachine.util.ExceptionHandler;
import vendingmachine.validator.InputValidator;

public class VendingMachineService {

	private VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
	}

	public void inputChangeAmount(String vendingMachinePrice) {
		vendingMachine.inputChangAmount(Integer.parseInt(vendingMachinePrice));
	}

	public boolean validateVendingMachineChange(String change) {
		boolean isValid = InputValidator.isNotEmpty(change)
			&& InputValidator.isDigit(change)
			&& InputValidator.isGreaterThan(Constants.VENDING_MACHINE_CHANGE_MIN_VALUE, change)
			&& InputValidator.isDivided(Constants.VENDING_MACHINE_CHANGE_DENOMINATOR, change);
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_VENDING_MACHINE_CHANGE);
		return isValid;
	}

	public void generateCoins() {
		vendingMachine.generateCoins();
	}

	public boolean validateInputAmount(String inputAmount) {
		boolean isValid = InputValidator.isNotEmpty(inputAmount)
			&& InputValidator.isDigit(inputAmount)
			&& InputValidator.isGreaterThan(Constants.INPUT_AMOUNT_MIN_VALUE, inputAmount);
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_USER_INPUT_AMOUNT);
		return isValid;
	}

	public void inputUserInputAmount(String inputAmount) {
		vendingMachine.inputUserInputAmount(Integer.parseInt(inputAmount));
	}
}
