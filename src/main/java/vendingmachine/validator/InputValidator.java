package vendingmachine.validator;

import java.util.ArrayList;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.exception.InputException;

public class InputValidator {
	private static final int itemIndex = 0;
	private static final int priceIndex = 1;
	private static final int stockIndex = 2;
	private static final String MONEY_REGEX = "\\d+0";
	private static final String STOCK_REGEX = "[1-9]+[0-9]*";
	private static final int MINIMUM_MONEY_SIZE = 100;

	public static Beverages checkInputForm(String input) {
		ArrayList<String> items = new ArrayList<>();
		checkSemicolon(input);

		String[] itemList = input.split(";");
		for (String item : itemList) {
			checkBracket(item);
			item = item.substring(1, item.length() - 1);
			items.add(item);
		}
		return splitItem(items);
	}

	private static Beverages splitItem(ArrayList<String> itemPriceStock) {
		Beverages beverages = new Beverages();
		for (String itemInfoList : itemPriceStock) {
			String[] itemInfo = itemInfoList.split(",");
			String name = itemInfo[itemIndex];
			int price = InputValidator.checkPriceForm(itemInfo[priceIndex]);
			int stock = InputValidator.checkStockForm(itemInfo[stockIndex]);
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

	private static void checkBracket(String input) {
		if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
			InputException.printNotFoundBracketError();
		}
	}

}
