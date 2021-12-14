package vendingmachine;

public class InputChecker {
	public static void checkNumber(String inputNumber) {
		for (int i = 0; i < inputNumber.length(); i++) {
			if (!Character.isDigit(inputNumber.charAt(i))) {
				throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
			}
		}
	}
}
