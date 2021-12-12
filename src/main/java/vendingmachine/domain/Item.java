package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Item {
	public static final String ITEM_ATTRIBUTE_SEPARATOR = ",";
	public static final int BEGIN_INDEX = 1;
	private final String itemName;
	private final Integer price;
	private Integer quantity;

	private Item(String itemName, String price, String quantity) {
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
		this.quantity = Integer.parseInt(quantity);
	}

	public static List<Item> createList(List<String> inputValue) {
		List<Item> itemList = new ArrayList<>();

		inputValue.forEach(string -> {
			string = removeBracket(string);
			String[] attributes = string.split(ITEM_ATTRIBUTE_SEPARATOR);
			itemList.add(new Item(attributes[0], attributes[1], attributes[2]));
		});

		return itemList;
	}

	private static String removeBracket(String string) {
		return string.substring(BEGIN_INDEX, string.length() - 1);
	}

	public void sold() {
		this.quantity--;
	}

	public String getItemName() {
		return itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
}
