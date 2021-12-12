package vendingmachine.service;

import java.util.HashMap;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Constants;
import vendingmachine.util.ExceptionHandler;
import vendingmachine.validator.InputValidator;

public final class VendingMachineService {
	private final VendingMachine vendingMachine = new VendingMachine();

	public VendingMachine getVendingMachine() {
		return vendingMachine;
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

	public HashMap<Integer, Integer> returnChange(int userInputAmount) {
		return vendingMachine.selectCoinsToBeReturned(userInputAmount);
	}
}
