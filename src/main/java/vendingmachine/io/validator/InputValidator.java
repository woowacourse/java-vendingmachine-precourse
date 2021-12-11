package vendingmachine.io.validator;

import vendingmachine.data.VendingMachineData;
import vendingmachine.exception.IntegerTooSmallException;
import vendingmachine.exception.ValueNotIntegerException;

public class InputValidator {

	public static void validMoneyValue(String money) {
		int tmp;
		try {
			if (Integer.parseInt(money) <= 0) {
				throw new IntegerTooSmallException(VendingMachineData.INPUT_VALUE_TOO_SMALL_ERROR);
			}
		} catch (NumberFormatException nfe) {
			throw new ValueNotIntegerException(VendingMachineData.INPUT_VALUE_NOT_INTEGER_ERROR, nfe);
		}
	}
}
