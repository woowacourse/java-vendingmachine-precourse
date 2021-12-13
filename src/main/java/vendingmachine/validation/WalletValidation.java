package vendingmachine.validation;

public class WalletValidation {

	public static void setWalletValidation(String input) {
		UtilValidation.isNumber(input);
		int value = Integer.parseInt(input);
		UtilValidation.isNaturalNumber(value);
		UtilValidation.canDivideMinCoin(value);
	}
}
