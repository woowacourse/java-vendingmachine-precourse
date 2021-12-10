package vendingmachine.validator;

public class BalanceValidator extends Validator {
	private static final int MULTIPLE = 10;

	public static void validateUserBalance(String input) {
		validateNumeric(input);

		int parsedNumber = Integer.parseInt(input);
		validateNaturalNumber(parsedNumber);
	}

	public static void validateVendingMachineBalance(String input) {
		validateNumeric(input);

		int parsedNumber = Integer.parseInt(input);
		validateNaturalNumber(parsedNumber);
		validateMultiple(parsedNumber, MULTIPLE);
	}
}
