package vendingmachine.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.exception.InputException;

public class InputValidator {
	private static final int nameIndex = 0;
	private static final int priceIndex = 1;
	private static final int stockIndex = 2;
	private static final int INFO_SIZE = 3;
	private static final int MINIMUM_MONEY_SIZE = 100;
	private static final String MONEY_REGEX = "\\d+0";
	private static final String STOCK_REGEX = "[1-9]+[0-9]*";
	private static final String NAME_REGEX = "[a-zA-Z0-9가-힣]+";
	private static final String BRACKET_REGEX = "^\\[.+,.+,.+]$";
	private static final String OPEN_BRACKET_REGEX = "\\[";
	private static final String CLOSE_BRACKET_REGEX = "\\]";

	public static Beverages checkInputForm(String input) {
		ArrayList<String> items = new ArrayList<>();
		checkSemicolon(input);
		checkBracket(input);
		String[] itemList = input.split(";");
		Arrays.stream(itemList).forEach(item -> {
			checkBracket(item);
			String itemInfo = eraseBracket(item);
			items.add(itemInfo);
		});
		return splitItem(items);
	}

	private static Beverages splitItem(ArrayList<String> itemPriceStock) {
		Beverages beverages = new Beverages();
		itemPriceStock.stream().map(beveragesInfoList -> beveragesInfoList.split(",")).forEach(beverageInfo -> {
			validationInfoForm(beverageInfo);
			String name = checkNameForm(beverageInfo[nameIndex]);
			int price = checkPriceForm(beverageInfo[priceIndex]);
			int stock = checkStockForm(beverageInfo[stockIndex]);
			beverages.add(new Beverage(name, price), stock);
		});
		validateDuplicateBeverage(beverages);
		return beverages;
	}

	private static void validateDuplicateBeverage(Beverages beverages) {
		Set<String> compareToName = beverages.getBeverages()
			.keySet()
			.stream()
			.map(Beverage::getName)
			.collect(Collectors.toSet());
		if (compareToName.size() != beverages.size()) {
			InputException.printDuplicatedBeverage();
		}
	}

	private static void validationInfoForm(String[] itemList) {
		if (itemList.length != INFO_SIZE) {
			InputException.printNotEnoughInforror();
		}
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
		return input.replaceAll(OPEN_BRACKET_REGEX, "").replaceAll(CLOSE_BRACKET_REGEX, "");
	}

	private static void checkBracket(String input) {
		if (!input.matches(BRACKET_REGEX)) {
			InputException.printNotFoundBracketError();
		}
	}

	private static String checkNameForm(String input) {
		if (!input.matches(NAME_REGEX)) {
			InputException.printNotNameFormError();
		}
		return input;
	}

}
