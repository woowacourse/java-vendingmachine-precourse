package vendingmachine.validator;

public class BalanceValidator extends Validator {
	private static final int MULTIPLE = 10;

	public static void validateUserBalance(int input) {
		validateNaturalNumber(input);
	}

	public static void validateVendingMachineBalance(int input) {
		validateNaturalNumber(input);
		validateMultiple(input, MULTIPLE);
	}
}
