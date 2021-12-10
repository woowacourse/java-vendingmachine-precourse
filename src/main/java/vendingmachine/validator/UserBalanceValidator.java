package vendingmachine.validator;

public class UserBalanceValidator extends Validator {
	public static void validateUserBalance(String input) {
		validateNumeric(input);

		int parsedNumber = Integer.parseInt(input);
		validateNaturalNumber(parsedNumber);
	}
}
