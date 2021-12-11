package vendingmachine.validator;

import java.util.ArrayList;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.exception.InputException;

public class InputValidator {
	private static final int nameIndex = 0;
	private static final int priceIndex = 1;
	private static final int stockIndex = 2;
	private static final int MINIMUM_MONEY_SIZE = 100;
	private static final String MONEY_REGEX = "\\d+0";
	private static final String STOCK_REGEX = "[1-9]+[0-9]*";
	private static final String BRACKET_REGEX = "\\[(.*)\\]";
	private static final String OPEN_BRACKET_REGEX = "\\[";
	private static final String CLOSE_BRACKET_REGEX = "\\]";

	public static Beverages checkInputForm(String input) {
		ArrayList<String> items = new ArrayList<>();
		checkSemicolon(input);

		String[] itemList = input.split(";");
		for (String item : itemList) {
			String itemInfo = eraseBracket(item);
			items.add(itemInfo);
		}
		return splitItem(items);
	}

	private static Beverages splitItem(ArrayList<String> itemPriceStock) {
		Beverages beverages = new Beverages();
		for (String beveragesInfoList : itemPriceStock) {
			String[] beverageInfo = beveragesInfoList.split(",");
			String name = beverageInfo[nameIndex];
			int price = InputValidator.checkPriceForm(beverageInfo[priceIndex]);
			int stock = InputValidator.checkStockForm(beverageInfo[stockIndex]);
			beverages.add(new Beverage(name, price), stock);
		}
		return beverages;
	}

	public static int checkMoneyForm(String input) {
		if (!input.matches(MONEY_REGEX)) {
			InputException.printNotMoneyFormError();
		}
		return Integer.parseInt(input);
	}

	public static int checkPriceForm(String input) {
		int money = checkMoneyForm(input);
		if (money < MINIMUM_MONEY_SIZE) {
			InputException.printLessThanHundredError();
		}
		return money;
	}

	public static int checkStockForm(String input) {
		if (!input.matches(STOCK_REGEX)) {
			InputException.printNotStockFormError();
		}
		return Integer.parseInt(input);
	}

	private static void checkSemicolon(String input) {
		if (input.contains("][")) {
			InputException.printNotFoundSemicolonError();
		}
	}

	private static String eraseBracket(String input) {

		if (!input.matches(BRACKET_REGEX)) {
			InputException.printNotFoundBracketError();
		}
		return input.replaceAll(OPEN_BRACKET_REGEX, "").replaceAll(CLOSE_BRACKET_REGEX, "");
	}

}
