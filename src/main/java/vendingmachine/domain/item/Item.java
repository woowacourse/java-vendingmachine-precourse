package vendingmachine.domain.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.validator.ItemValidator;

public class Item {
	private static final String SPLIT_DELIMITER = ",";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String BLANK_CHAR = "";
	private static final String TO_STRING_FORMAT = "{ItemName=%s, ItemPrice=%s, ItemAmount=%s}";

	private final ItemName name;
	private final ItemPrice price;
	private ItemAmount amount;

	private Item(ItemName name, ItemPrice price, ItemAmount amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public static Item from(String input) {
		ItemValidator.validateItemInputFormat(input);

		List<String> elements = parseInput(removeBracket(input));

		ItemName name = ItemName.from(elements.get(0));
		ItemPrice price = ItemPrice.from(elements.get(1));
		ItemAmount amount = ItemAmount.from(elements.get(2));

		return new Item(name, price, amount);
	}

	private static String removeBracket(String input) {
		return input.replace(OPEN_BRACKET, BLANK_CHAR).replace(CLOSE_BRACKET, BLANK_CHAR);
	}

	private static List<String> parseInput(String input) {
		return Arrays.stream(input.split(SPLIT_DELIMITER))
			.collect(Collectors.toList());
	}

	public ItemName getItemName() {
		return this.name;
	}

	public ItemPrice getItemPrice() {
		return this.price;
	}

	public boolean isSoldOut() {
		return this.amount.toInt() <= 0;
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, this.name.toString(), this.price.toString(), this.amount.toString());
	}
}
