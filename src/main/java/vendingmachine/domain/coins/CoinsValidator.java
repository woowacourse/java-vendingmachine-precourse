package vendingmachine.domain.coins;

import vendingmachine.exception.NotAMultipleException;
import vendingmachine.exception.NotNaturalNumberException;
import vendingmachine.exception.NotNumericException;
import vendingmachine.utils.NumberUtils;
import vendingmachine.utils.StringUtils;

public class CoinsValidator {
	private static final int MULTIPLE = 10;

	public static void validateVendingMachineBalance(String vendingMachineBalance) {
		validateNumeric(vendingMachineBalance);
		validateNaturalNumber(vendingMachineBalance);
		validateMultiple(vendingMachineBalance);
	}

	private static void validateNumeric(String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new NotNumericException();
		}
	}

	private static void validateNaturalNumber(String input) {
		int parsedNumber = Integer.parseInt(input);
		if (!NumberUtils.isNaturalNumber(parsedNumber)) {
			throw new NotNaturalNumberException();
		}
	}

	private static void validateMultiple(String input) {
		int parsedNumber = Integer.parseInt(input);
		if (NumberUtils.isMultipleOf(parsedNumber, MULTIPLE)) {
			throw new NotAMultipleException(MULTIPLE);
		}
	}
}
