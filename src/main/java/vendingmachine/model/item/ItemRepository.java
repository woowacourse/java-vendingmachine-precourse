package vendingmachine.model.item;

import static java.util.Comparator.comparingInt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRepository {
	private static Map<String, Item> map = new HashMap<>();

	public static boolean existsByName(String name) {
		return map.containsKey(name);
	}

	public static void save(Item item) {
		map.put(item.getName(), item);
	}

	public static void saveAll(List<Item> items) {
		items.stream().forEach(ItemRepository::save);
	}

	public static Item findByName(String name) {
		return map.get(name);
	}

	public static boolean isAllSoldOut() {
		return map.values().stream().allMatch(Item::isSoldOut);
	}

	public static Item findLowestPriceItem() {
		return map.values().stream()
			.sorted(comparingInt(Item::getPrice))
			.findFirst()
			.get();
	}
}
