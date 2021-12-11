package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Items {

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

	private List<String> separateItems(String itemList) {
		return Arrays.asList(itemList.split(";"));
	}

	private String processItem(String item) {
		return item.substring(1, item.length() - 1);
	}

	private Item createItem(String item) {
		String[] separateItem = item.split(",");
		return new Item(separateItem[0], Integer.parseInt(separateItem[1]), Integer.parseInt(separateItem[2]));
	}

	public boolean check(int amount) {
		return checkLowestPrice(amount) && checkQuantity();
	}

	private boolean checkLowestPrice(int amount) {
		int lowestPrice = list.stream()
			.mapToInt(Item::getPrice)
			.findFirst()
			.orElse(0);

		return amount >= lowestPrice;
	}

	private boolean checkQuantity() {
		long count = list.stream()
			.filter(item -> item.getQuantity() != 0)
			.count();

		return count != 0;
	}

	public List<String> toNames() {
		return list.stream()
			.map(Item::getName)
			.collect(Collectors.toList());
	}

	public int getStockByName(String itemName) {
		return list.stream()
			.filter(item -> item.getName().equals(itemName))
			.mapToInt(Item::getQuantity)
			.sum();
	}

	public Item findByName(String itemName) {
		return list.stream()
			.filter(item -> item.getName().equals(itemName))
			.findFirst()
			.orElse(null);
	}
}
