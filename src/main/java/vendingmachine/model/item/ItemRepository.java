package vendingmachine.model.item;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Comparator.comparingInt;

public class ItemRepository {
	private Map<String, Item> map = new HashMap<>();

	public boolean existsByName(String name) {
		return map.containsKey(name);
	}

	public void save(Item item) {
		map.put(item.getName(), item);
	}

	public void saveAll(List<Item> items) {
		items.stream().forEach(this::save);
	}

	public Item findByName(String name) {
		return map.get(name);
	}

	public boolean isAllSoldOut() {
		return map.values().stream().allMatch(Item::isSoldOut);
	}

	public Item findLowestPriceItem() {
		return map.values().stream()
			.sorted(comparingInt(Item::getPrice))
			.findFirst()
			.get();
	}
}
