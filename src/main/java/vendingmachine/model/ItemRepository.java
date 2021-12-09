package vendingmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
