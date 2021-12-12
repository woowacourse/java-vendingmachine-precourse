package vendingmachine.view;

import vendingmachine.utils.Validator;

public class UserMoneyInputView implements InputView {

	public String checkAllConditions(String userInput) {
		try {
			Validator.validatePriceInput(userInput);
			return userInput;
		} catch (IllegalArgumentException error) {
			System.out.print(error.getMessage());
			return BLANK_STRING;
		}
	}

	public String getInput() {
		OutputView.noticePayMoneyInput();
		String nowInput = BLANK_STRING;
		while (nowInput.isEmpty()) {
			String userInput = camp.nextstep.edu.missionutils.Console.readLine();
			nowInput = checkAllConditions(userInput);
		}
		return nowInput;
	}
}
