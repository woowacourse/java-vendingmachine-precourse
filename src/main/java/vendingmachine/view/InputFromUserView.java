package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utill.InputMoneyValidator;

public class InputFromUserView {
	private static final String USER_MONEY_INPUT_MSG = "투입 금액을 입력해 주세요.";

	private InputMoneyValidator inputMoneyValidator;

	public InputFromUserView(InputMoneyValidator inputMoneyValidator) {
		this.inputMoneyValidator = inputMoneyValidator;
	}

	public int inputMoneyFromUser() {
		System.out.println("\n" + USER_MONEY_INPUT_MSG);
		String inputAmount = Console.readLine();

		int amount = inputMoneyValidator.validateMoney(inputAmount);
		if (amount >= 0) {
			return amount;
		}
		return inputMoneyFromUser();
	}
}
