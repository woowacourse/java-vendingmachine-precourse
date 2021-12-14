package vendingmachine.resource;

import static vendingmachine.constants.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemStorage {
	private static final ItemStorage itemStorage = new ItemStorage();

	private final List<Item> itemList;

	private ItemStorage() {
		itemList = new ArrayList<>();
	}

	public static ItemStorage getItemStorage() {
		return itemStorage;
	}

	public void creatItem(String name, int price, int stock) {
		itemList.add(new Item(name, price, stock));
	}

	public List<Integer> getPriceList() {
		return itemList.stream().map(Item::getPrice).collect(Collectors.toList());
	}

	public List<Integer> getStockList() {
		return itemList.stream().map(Item::getStock).collect(Collectors.toList());
	}

	public List<String> getNameList() {
		return itemList.stream().map(Item::getName).collect(Collectors.toList());
	}

	public Optional<Integer> getPriceByName(String name) {
		return itemList.stream()
				.filter(item -> Objects.equals(item.getName(), name))
				.map(Item::getPrice)
				.findAny();
	}

	public void reduceItemStock(String name) {
		getItemByName(name).orElseThrow(() -> new IllegalArgumentException(DONT_EXISTING_ITEM_ERROR_MESSAGE))
				.reduceStock();
	}

	private Optional<Item> getItemByName(String name) {
		return itemList.stream()
				.filter(item -> Objects.equals(item.getName(), name))
				.findAny();
	}
}
