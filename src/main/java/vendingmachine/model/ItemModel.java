package vendingmachine.model;

import static vendingmachine.constants.ErrorMessages.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.resource.ItemStorage;

public class ItemModel {
	private final static ItemModel itemModel = new ItemModel();

	private final ItemStorage itemStorage;

	private ItemModel() {
		itemStorage = ItemStorage.getItemStorage();
	}

	public static ItemModel getItemModel() {
		return itemModel;
	}

	public void createItems(String stringItemList) {
		List<String> itemList = parseItemStringIntoItemList(stringItemList);
		for (int i = 0; i < itemList.size() / 3; i++) {
			String name = itemList.get(i * 3);
			int price = Integer.parseInt(itemList.get(i * 3 + 1));
			int stock = Integer.parseInt(itemList.get(i * 3 + 2));
			itemStorage.creatItem(name, price, stock);
		}
	}

	public int getMinimumPrice() {
		return itemStorage.getPriceList().stream()
				.mapToInt(Integer::intValue)
				.min()
				.orElseThrow(() -> new IllegalArgumentException(CANT_FIND_MINIMUM_PRICE_ITEM_ERROR_MESSAGE));
	}

	public boolean hasStock() {
		return itemStorage.getStockList().stream()
				.mapToInt(Integer::intValue)
				.sum() > 0;
	}

	public void sellItem(String item) {
		itemStorage.reduceItemStock(item);
	}

	public int getPriceByName(String name) {
		return itemStorage.getPriceByName(name)
				.orElseThrow(() -> new IllegalArgumentException(DONT_EXISTING_ITEM_ERROR_MESSAGE));
	}

	private List<String> parseItemStringIntoItemList(String items) {
		return Arrays.stream(items.split(";"))
				.map(item -> item.substring(1, item.length() - 1))
				.map(itemElement -> itemElement.split(","))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList());
	}
}
