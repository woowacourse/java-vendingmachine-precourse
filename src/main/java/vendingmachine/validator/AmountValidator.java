package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;

public class AmountValidator {
	public static void checkVendingMachineAmount(String inputAmount) {
		int amount = toInteger(inputAmount);
	}

	private static int toInteger(String inputAmount) {
		try {
			return Integer.parseInt(inputAmount);
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException(AMOUNT_IS_NOT_INTEGER_ERROR_MESSAGE);
		}
	}
}
