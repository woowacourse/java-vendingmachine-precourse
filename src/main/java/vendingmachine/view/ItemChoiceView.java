package vendingmachine.view;

import vendingmachine.utils.Validator;

public class ItemChoiceView implements InputView {
	public String checkAllCondtions(String nowInput) {
		try {
			Validator.validateNameInput(nowInput);
			return nowInput;
		} catch (IllegalArgumentException error) {
			System.out.print(error.getMessage());
			return BLANK_STRING;
		}
	}
}
