package vendingmachine.domain.Items;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.item.Item;
import vendingmachine.validator.ItemsValidator;

public class Items {
	private static final String SPLIT_DELIMITER = ";";

	private final List<Item> items;

	private Items(List<Item> items) {
		this.items = items;
	}

	public static Items from(String input) {
		ItemsValidator.validateItemsInputFormat(input);

		List<Item> items = parseInput(input);
		return new Items(items);
	}

	private static List<Item> parseInput(String input) {
		return Arrays.stream(input.split(SPLIT_DELIMITER))
			.map(Item::from)
			.collect(Collectors.toList());
	}

	public boolean isAllSoldOut() {
		return this.items.stream()
			.allMatch(Item::isSoldOut);
	}

	@Override
	public String toString() {
		return items.toString();
	}
}
