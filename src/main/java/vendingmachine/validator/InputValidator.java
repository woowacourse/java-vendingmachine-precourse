package vendingmachine.validator;

import java.util.ArrayList;

import vendingmachine.exception.InputException;

public class InputValidator {

	public static ArrayList<String> checkInputForm(String input) {
		ArrayList<String> items = new ArrayList<>();
		InputException.checkSemicolon(input);

		String[] itemList = input.split(";");
		for (String item : itemList) {
			InputException.checkBracket(item);
			item = item.substring(1, item.length() - 1);
			items.add(item);
		}
		return items;
	}

}
