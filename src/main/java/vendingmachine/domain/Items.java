package vendingmachine.domain;

import static vendingmachine.utils.Message.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Items {

	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	private List<Item> list;

	public Items() {
		list = new ArrayList<>();
	}

	public void insertItems(String itemList) {
		List<String> items = separateItems(itemList);
		for (String item : items) {
			String processedItem = processItem(item);
			list.add(createItem(processedItem));
		}
	}

	public boolean check(int amount) {
		return checkLowestPrice(amount) && checkQuantity();
	}

	public List<String> getNames() {
		return list.stream()
			.map(Item::getName)
			.collect(Collectors.toList());
	}

	public int purchase(String itemName, int amount) {
		Item item = findByName(itemName);
		int price = item.purchase(amount);

		if (item.checkOutOfStock()) {
			list.remove(item);
		}
		return price;
	}

	public Item findByName(String itemName) {
		return list.stream()
			.filter(item -> item.checkEqualsName(itemName))
			.findFirst()
			.orElse(null);
	}

	private List<String> separateItems(String itemList) {
		return Arrays.asList(itemList.split(ITEM_SEPARATOR));
	}

	private String processItem(String item) {
		return item.substring(1, item.length() - 1);
	}

	private Item createItem(String item) {
		String[] separateItem = item.split(ITEM_ELEMENT_SEPARATOR);
		return new Item(
			separateItem[NAME],
			Integer.parseInt(separateItem[PRICE]),
			Integer.parseInt(separateItem[QUANTITY])
		);
	}

	private boolean checkLowestPrice(int amount) {
		int lowestPrice = list.stream()
			.mapToInt(Item::getPrice)
			.sorted()
			.findFirst()
			.orElse(0);

		return amount >= lowestPrice;
	}

	private boolean checkQuantity() {
		long count = list.stream()
			.filter(item -> !item.checkOutOfStock())
			.count();

		return count != 0;
	}
}
