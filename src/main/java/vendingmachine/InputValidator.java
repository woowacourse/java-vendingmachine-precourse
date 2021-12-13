package vendingmachine;

public class InputValidator {

	public static boolean validateNumber(String number){
		for (int i = 0; i < number.length(); i++) {
			if ((number.charAt(i) < '0') || (number.charAt(i) > '9')) {
				throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
			}
		}
		return true;
	}
}
