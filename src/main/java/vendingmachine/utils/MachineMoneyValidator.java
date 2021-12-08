package vendingmachine.utils;

public class MachineMoneyValidator {
	public static final String ERROR_NOT_INTEGER = "[ERROR] 자판기 보유 금액은 숫자로 입력해주세요.";
	public static final String ERROR_NOT_POSITIVE = "[ERROR] 자판기 보유 금액은 0원보다 작을 수 없습니다.";
	public static final String ERROR_NOT_MULTIPLE_OF_TEN = "[ERROR] 자판기 보유 금액의 최소 단위는 10원입니다.";

	public void validateMachineMoney(String inputValue) {
		isInteger(inputValue);
		isPositive(inputValue);
		isMultipleOfTen(inputValue);
	}

	private void isInteger(String inputValue) {
		try {
			Integer.parseInt(inputValue);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private void isPositive(String inputValue) {
		int intValue = Integer.parseInt(inputValue);
		if (intValue <= 0) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
		}
	}

	private void isMultipleOfTen(String inputValue) {
		int intValue = Integer.parseInt(inputValue);
		if (intValue % 10 != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_OF_TEN);
		}
	}
}
