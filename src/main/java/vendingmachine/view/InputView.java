package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ERROR = "[ERROR] ";
	private static final String NON_DIGIT_ERROR = ERROR + "입력 금액은 숫자여야 합니다.";
	private static final String NEGATIVE_DIGIT_ERROR = ERROR + "입력 금액은 0 이상의 숫자여야 합니다.";

	public int scanPrice() {
		try {
			int price = Integer.parseInt(Console.readLine());
			if (price < 0) {
				throw new IllegalArgumentException(NEGATIVE_DIGIT_ERROR);
			}
			return price;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NON_DIGIT_ERROR);
		}
	}
}


