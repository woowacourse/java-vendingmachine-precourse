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
}
