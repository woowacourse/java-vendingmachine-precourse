package vendingmachine.validator;

public class CoinsValidator extends Validator {
	private static final int MULTIPLE = 10;

	public static void validateVendingMachineBalance(String vendingMachineBalance) {
		validateNumeric(vendingMachineBalance);

		int parsedNumber = Integer.parseInt(vendingMachineBalance);
		validateNaturalNumber(parsedNumber);
		validateMultiple(parsedNumber, MULTIPLE);
	}
}
