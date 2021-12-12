package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String COINS_INPUT_HAS_VENDING_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요";
	private static final String ERROR_NOT_NUMBER_MESSAGE = "숫자의 입력이 아닙니다.";

	public static int getInputCoins() {
		System.out.println(COINS_INPUT_HAS_VENDING_MACHINE);
		return getConvertInt();
	}

	private static int getConvertInt() {
		try {
			final String inputCoins = Console.readLine();
			return Integer.parseInt(inputCoins);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE);
		}
	}
}
