package vendingmachine.reader;

import camp.nextstep.edu.missionutils.Console;

public class ExchangeAmountReader {
	public int read() {
		printInputMessage();
		String value = Console.readLine();
		checkIsValid(value);
		return Integer.valueOf(value);
	}

	private void printInputMessage() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}

	private void checkIsValid(String value) {
		checkIsNumber(value);
		checkIsTenTimesNumber(value);
	}

	private void checkIsTenTimesNumber(String value) {
		Integer amount = Integer.valueOf(value);

		if (amount % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 자판기가 보유할 금액은 10원으로 나눠어 떨어져야 합니다.");
		}
	}

	private void checkIsNumber(String value) {
		if (!value.matches("[0-9]*")) {
			throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
	}
}
