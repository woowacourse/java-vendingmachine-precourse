package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeverageShop {
	private static final String SPLIT_DELIMITER = ";";
	private static final Pattern INFO_TOKENIZE_PATTERN = Pattern.compile("\\[(.*),(.*),(.*)\\]");
	private static final int NAME_GROUP = 1;
	private static final int PRICE_GROUP = 2;
	private static final int COUNT_GROUP = 3;

	private static final String NAME_DUPLICATE_ERROR = "[ERROR] 음료가 중복됩니다.";
	private static final String INVALID_INFO_FORM_ERROR = "[ERROR] 올바른 형식으로 입력해야 합니다.";

	private BeverageShop() {
	}

	public static Beverages getBeverages(String beveragesInfo) {
		String[] infos = beveragesInfo.split(SPLIT_DELIMITER);
		return new Beverages(getBeveragesFromInfo(infos));
	}

	private static List<Beverage> getBeveragesFromInfo(String[] infos) {
		List<Beverage> beverages = new ArrayList<>();
		for (String beverageInfo : infos) {
			Beverage newBeverage = getBeverageFromInfo(beverageInfo);
			checkNotDuplicate(beverages, newBeverage);
			beverages.add(newBeverage);
		}
		return beverages;
	}

	private static void checkNotDuplicate(List<Beverage> beverages, Beverage newBeverage) {
		if (beverages.contains(newBeverage)) {
			throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
		}
	}

	private static Beverage getBeverageFromInfo(String beverageInfo) {
		Matcher matcher = INFO_TOKENIZE_PATTERN.matcher(beverageInfo);
		if (matcher.find()) {
			return getBeverageWithMatcher(matcher);
		}
		throw new IllegalArgumentException(INVALID_INFO_FORM_ERROR);
	}

	private static Beverage getBeverageWithMatcher(Matcher matcher) {
		String name = matcher.group(NAME_GROUP);
		Money price = Money.from(matcher.group(PRICE_GROUP));
		int count = Integer.parseInt(matcher.group(COUNT_GROUP));
		return new Beverage(name, price, count);
	}
}
