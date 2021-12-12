package vendingmachine.view;

import vendingmachine.utils.Validator;

public class ItemChoiceInputView implements InputView {
	public String checkAllConditions(String nowInput) {
		try {
			Validator.validateNameInput(nowInput);
			return nowInput;
		} catch (IllegalArgumentException error) {
			System.out.print(error.getMessage());
			return BLANK_STRING;
		}
	}

	public String getInput() {
		OutputView.noticeBuyItemInput();
		String nowInput = BLANK_STRING;
		while (nowInput.isEmpty()) {
			String userInput = camp.nextstep.edu.missionutils.Console.readLine();
			nowInput = checkAllConditions(userInput);
		}
		return nowInput;
	}
}
