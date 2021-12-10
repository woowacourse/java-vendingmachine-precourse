package vendingmachine.domain.items;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.ItemName;
import vendingmachine.domain.item.ItemPrice;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.exception.ItemNotFoundException;
import vendingmachine.exception.NotEnoughBalanceException;
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

	public ItemPrice getMinItemPrice() {
		List<ItemPrice> itemPrices = items.stream()
			.map(Item::getItemPrice)
			.collect(Collectors.toList());

		return Collections.min(itemPrices);
	}

	// TODO: 리팩토링 필요
	public Items buyItem(Item item, UserBalance userBalance) {
		if (!item.isEnoughBalance(userBalance)) {
			throw new NotEnoughBalanceException();
		}

		List<Item> soldItems = items.stream().map(singleItem -> {
			if (singleItem.getItemName().equals(item.getItemName())) {
				return singleItem.buy();
			}
			return singleItem;
		}).collect(Collectors.toList());

		return new Items(soldItems);
	}

	public Item findByItemName(ItemName itemName) {
		List<Item> foundItems = items.stream()
			.filter(item -> item.getItemName().equals(itemName))
			.collect(Collectors.toList());

		if (foundItems.size() != 1) {
			throw new ItemNotFoundException();
		}

		return foundItems.get(0);
	}

	@Override
	public String toString() {
		return items.toString();
	}
}
