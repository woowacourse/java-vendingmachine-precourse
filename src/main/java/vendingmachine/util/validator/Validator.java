package vendingmachine.util.validator;

public class Validator {
	private static final int DIVISIBLE_VALUE = 10;

	public static void isEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
		}
	}

	public static void isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 알맞게 입력해주세요.");
		}
	}

	public static void isDivisible(String input) {
		if (Integer.parseInt(input) % DIVISIBLE_VALUE != 0) {
			throw new IllegalArgumentException("[ERROR] 돈은 10원으로 나누어 떨어져야 합니다.");
		}
	}
}
