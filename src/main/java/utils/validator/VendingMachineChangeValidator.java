package utils.validator;

import java.util.regex.Pattern;

public class VendingMachineChangeValidator {
	private static final int MINIMUM_MONEY_UNIT = 10;
	private static final int RIGHT_NUMBER = 0;
	private static final int MIN_VENDING_MACHINE_CHANGE_INPUT_LENGTH = 1;
	private static final String ZERO = "0";
	private static final String BLANK = " ";
	private static final String NUMBER_PATTERN = "^[0-9]+$";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 없다.";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈에 공백이 있다.";
	private static final String NOT_RIGHT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 올바른수(양수)가 아니다.";
	private static final String START_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 0으로 시작한다.";
	private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 10으로 나누어 떨어지지 않는다.";

	private VendingMachineChangeValidator() {
	}

	public static int checkValidVendingMachineChange(String vendingMachineChange) {
		if (isValidInputLength(vendingMachineChange) && !hasBlankInInput(vendingMachineChange) && isRightNumber(
			vendingMachineChange) && isDivisibleByMinimumMoneyUnit(vendingMachineChange)) {
			return Integer.parseInt(vendingMachineChange);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String vendingMachineChange) {
		if (vendingMachineChange.length() < MIN_VENDING_MACHINE_CHANGE_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean hasBlankInInput(String vendingMachineChange) {
		if (vendingMachineChange.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isRightNumber(String vendingMachineChange) {
		if (!Pattern.matches(NUMBER_PATTERN, vendingMachineChange)) {
			throw new IllegalArgumentException(NOT_RIGHT_NUMBER_ERROR_MESSAGE);
		}
		if (vendingMachineChange.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_NUMBER_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isDivisibleByMinimumMoneyUnit(String vendingMachineChange) {
		if (Integer.parseInt(vendingMachineChange) % MINIMUM_MONEY_UNIT != RIGHT_NUMBER) {
			throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
		}
		return true;
	}
}
