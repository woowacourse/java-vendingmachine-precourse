package vendingmachine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vendingmachine.domain.Item;

public class Parser {
	public static final int ITEM_NAME_INDEX = 0;
	public static final int ITEM_PRICE_INDEX = 1;
	public static final int ITEM_COUNT_INDEX = 2;

	public static List<String> parseToItemStringList(String merchandise) {
		List<String> item = Stream.of(merchandise.split(";"))
			.collect(Collectors.toList());
		return item;
	}

	public static Item parseToItem(String item) {
		item = item.replace("[", "").replace("]", "");
		String[] elements = item.split(",");
		String name = elements[ITEM_NAME_INDEX];
		int price = Integer.parseInt(elements[ITEM_PRICE_INDEX]);
		int count = Integer.parseInt(elements[ITEM_COUNT_INDEX]);
		return new Item(name, price, count);
	}
}
