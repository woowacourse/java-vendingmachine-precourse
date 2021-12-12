package vendingmachine.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Items {
	private final List<Item> items;

	public Items(List<Item> items) {
		validateDuplication(items);
		this.items = items;
	}

	public List<Item> findAll() {
		return Collections.unmodifiableList(items);
	}

	public Item findItemByName(String name, Money money) {
		Item foundItem = items.stream()
			.filter((item) -> name.equals(item.getName()))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("해당 이름의 상품을 찾을 수 없습니다."));
		if (foundItem.getAmount() <= 0) {
			throw new IllegalArgumentException("상품의 수량이 0개이므로 구매할 수 없습니다.");
		}
		if (!money.payable(foundItem.getCost())){
			throw new IllegalArgumentException("투입 금액보다 상품의 금액이 더 비싸므로 상품을 구매할 수 없습니다.");
		}
		return foundItem;
	}

	public boolean checkAllOutOfOrder() {
		return items.stream()
			.map(Item::getAmount)
			.allMatch((amount) -> amount == 0);
	}

	private void validateDuplication(List<Item> items) {
		Set<String> nonDuplicatedItems = items.stream()
			.map(Item::getName)
			.collect(Collectors.toSet());
		if (nonDuplicatedItems.size() < items.size()) {
			throw new IllegalArgumentException("상품명이 중복되지 않아야 합니다.");
		}
	}
}
