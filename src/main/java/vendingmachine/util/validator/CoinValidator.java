package vendingmachine.util.validator;

public class CoinValidator extends Validator {
	public static void isRightCoin(String input) throws IllegalArgumentException {
		isEmpty(input);
		isNumber(input);
		isPositive(input);
		isDivisible(input);
	}
}
