package vendingmachine.validator;

public class Validator {
	public static boolean checkMoneyInMachine(String moneyInVendingMachine) {
		try {
			NumberValidator.isInteger(moneyInVendingMachine);
			int intMoneyInVendingMachine = Integer.parseInt(moneyInVendingMachine);
			NumberValidator.isGreaterThanOrEqualToZero(intMoneyInVendingMachine);
			NumberValidator.isDivisibleByLowLimitOfCoin(intMoneyInVendingMachine);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
