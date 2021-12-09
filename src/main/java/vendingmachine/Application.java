package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		int amount = inputExchangeAmount();

	}

	private static int inputExchangeAmount() {
		printInputMessage();
		String value = inputValue();
		checkIsValid(value);
		return Integer.valueOf(value);
	}

	private static void checkIsValid(String value) {
		checkIsNumber(value);
		checkIsTenTimesNumber(value);
	}

	private static void checkIsTenTimesNumber(String value) {
		Integer amount = Integer.valueOf(value);
		if(amount % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 자판기가 보유할 금액은 10원으로 나눠어 떨어져야 합니다.");
		}
	}

	private static void checkIsNumber(String value) {
		if (!value.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
	}

	private static String inputValue() {
		String value = Console.readLine();
		return value;
	}

	private static void printInputMessage() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}
}
