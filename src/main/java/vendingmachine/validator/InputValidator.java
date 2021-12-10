package vendingmachine.validator;

import java.util.ArrayList;

import vendingmachine.exception.InputException;

public class InputValidator {

	private static final String REGEX = "-?\\d+";

	public static ArrayList<String> checkInputForm(String input) {
		ArrayList<String> items = new ArrayList<>();
		checkSemicolon(input);

		String[] itemList = input.split(";");
		for (String item : itemList) {
			checkBracket(item);
			item = item.substring(1, item.length() - 1);
			items.add(item);
		}
		return items;
	}

	public static int checkNumberForm(String input, String target) {
		if (!input.matches(REGEX)) {
			InputException.printNotNumberError(target);
		}
		return Integer.parseInt(input);
	}

	private static void checkSemicolon(String input) {
		if (!input.contains(";")) {
			InputException.printNotFoundSemicolonError();
		}
	}

	private static void checkBracket(String input) {
		if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
			InputException.printNotFoundBracketError();
		}
	}

}
