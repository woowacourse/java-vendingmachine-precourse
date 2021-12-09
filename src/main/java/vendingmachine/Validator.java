package vendingmachine;

public class Validator {

	private static final String ERROR_MSG_NOT_NUMERIC = "[ERROR] 숫자만 입력할 수 있습니다.";
	private static final String ERROR_MSG_LESS_THAN_MIN = "[ERROR] 입력 값은 10보다 커야합니다.";



	public static void isNumeric(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_MSG_NOT_NUMERIC);
		}
	}

	public static void minimumCheck(String input) {
		if (Integer.parseInt(input) < 10) {
			throw new IllegalArgumentException(ERROR_MSG_LESS_THAN_MIN);
		}
	}

	public static boolean moneyCheck(String input) {
		try {
			isNumeric(input);
			minimumCheck(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
