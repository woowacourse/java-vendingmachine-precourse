package vendingmachine.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.domain.Item;

public class Converter {
	public static List<Item> toItems(String inputText) {
		String[] splitItemList = inputText.split(";");
		Pattern pattern = ItemRegPattern.getPattern();
		List<Item> items = new ArrayList<>();

		for (String itemText : splitItemList) {
			Matcher m = pattern.matcher(itemText);
			Validator.validateMatcher(m);
			Item item = makeItem(m);
			items.add(item);
		}
		return items;
	}

	private static Item makeItem(Matcher m) {
		String itemName = m.group(1);
		int price = Integer.parseInt(m.group(2));
		int num = Integer.parseInt(m.group(3));
		Validator.validateItemName(itemName);
		Validator.validatePrice(price);
		return new Item(itemName, price, num);
	}
}
