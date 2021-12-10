package vendingmachine;

import java.util.Comparator;
import java.util.Map;

/**
 * 자판기의 상품 재고를 관리하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class ItemManager {
	private final Map<String, Item> items;

	public ItemManager(Map<String, Item> items) {
		this.items = items;
	}

	public int getMinPrice() {
		Item cheapestItem = items.values().stream()
			.min(Comparator.comparingInt(Item::getPrice)).get();
		return cheapestItem.getPrice();
	}
}
