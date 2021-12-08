package vendingmachine;

public class ValidationUtils {
	public static boolean validUnitMoney(int money) {
		return money % 10 == 0;
	}
}
