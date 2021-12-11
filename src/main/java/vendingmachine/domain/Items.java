package vendingmachine.domain;

import java.util.Collections;
import java.util.List;

public class Items {
	private final List<Item> items;

	public Items(List<Item> items) {
		this.items = items;
	}

	public List<Item> findAll() {
		return Collections.unmodifiableList(items);
	}

	public Item findItemByName(String name) {
		return items.stream()
			.filter((item) -> name.equals(item.getName()))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("해당 이름의 상품을 찾을 수 없습니다."));
	}

	public boolean checkAllOutOfOrder() {
		return items.stream()
			.map(Item::getAmount)
			.allMatch((amount) -> amount == 0);
	}
}
