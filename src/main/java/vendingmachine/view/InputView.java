package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Validators;

public class InputView {
	public static String getInput() {
		return Console.readLine();
	}

	public static int getMoney() {
		try {
			String inputValue = InputView.getInput();
			checkMoneyValidation(inputValue);
			return Integer.parseInt(inputValue);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMoney();
		}
	}

	private static void checkMoneyValidation(String inputValue) {
		Validators.checkNullOrEmpty(inputValue);
		Validators.checkValidFormatOfMoney(inputValue);
		Validators.checkValidRangeMoney(inputValue);
		// TODO 10의 배수 검증
		Validators.checkPassDemands(inputValue);
	}

}
