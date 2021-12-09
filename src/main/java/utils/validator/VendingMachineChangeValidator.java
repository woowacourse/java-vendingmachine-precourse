package utils.validator;

import java.util.regex.Pattern;

public class VendingMachineChangeValidator {
	private static final String NUMBER_PATTERN = "^[0-9]+$";

	private VendingMachineChangeValidator() {
	}

	public static int checkValidVendingMachineChange(String vendingMachineChange) {
		if (isValidVendingMachineChangeLength(vendingMachineChange) && !hasBlankInVendingMachineChange(
			vendingMachineChange)
			&& isRightNumber(vendingMachineChange) && isDivisibleByTen(vendingMachineChange)) {
			return Integer.parseInt(vendingMachineChange);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidVendingMachineChangeLength(String vendingMachineChange) {
		if (vendingMachineChange.length() == 0) {
			throw new IllegalArgumentException("[ERROR] 입력한 자판기 잔돈이 없다.");
		}
		return true;
	}

	private static boolean hasBlankInVendingMachineChange(String vendingMachineChange) {
		if (vendingMachineChange.contains(" ")) {
			throw new IllegalArgumentException("[ERROR] 입력한 자판기 잔돈에 공백이 있다.");
		}
		return false;
	}

	private static boolean isRightNumber(String vendingMachineChange) {
		if (!Pattern.matches(NUMBER_PATTERN, vendingMachineChange)) {
			throw new IllegalArgumentException("[ERROR] 입력한 자판기 잔돈이 올바른수(양수)가 아니다.");
		}
		if (vendingMachineChange.startsWith("0")) {
			throw new IllegalArgumentException("[ERROR] 입력한 자판기 잔돈이 0으로 시작한다.");
		}
		return true;
	}

	private static boolean isDivisibleByTen(String vendingMachineChange) {
		if (Integer.parseInt(vendingMachineChange) % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 입력한 자판기 잔돈이 10으로 나누어 떨어지지 않는다.");
		}
		return true;
	}
}
