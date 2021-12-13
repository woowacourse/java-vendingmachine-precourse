package vendingmachine.validation;

public class UserValidation {

	public static void setUserBalance(String input) {
		UtilValidation.isNumber(input);
		int value = Integer.parseInt(input);
		UtilValidation.isNaturalNumber(value);
	}

}
