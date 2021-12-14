package vendingmachine.utils;

public class Validators {
	public static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException("빈칸 입력은 허용하지 않는다.");
		}
	}

	public static void checkValidFormatOfMoney(String inputValue) {
		if (!(inputValue.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
		}
	}

	public static void checkValidRangeMoney(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (!(1 <= number && number <= 2147483647)) {
			throw new IllegalArgumentException("정상 범위(" + 1 + "~" + 2147483647 + ")가 아닙니다");
		}
	}

	public static void checkPassDemands(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (number % 10 != 0) {
			throw new IllegalArgumentException("10원 단위로 입력해주세요");
		}
	}
}
