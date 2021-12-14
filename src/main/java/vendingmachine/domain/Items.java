package vendingmachine.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Items {
	private static final String ERROR = "[ERROR] ";
	private static final String DUPLICATE_NAME_ERROR = ERROR + "상품명이 중복되지 않아야 합니다.";
	private static final String CANNOT_FIND_NAME_ERROR = ERROR + "해당 이름의 상품을 찾을 수 없습니다.";
	private final List<Item> items;

	public Items(final List<Item> items) {
		validateDuplication(items);
		this.items = items;
	}

	public List<Item> findAll() {
		return Collections.unmodifiableList(items);
	}

	public Item findItemByName(final String name) {
		return items.stream()
			.filter((item) -> name.equals(item.getName()))
			.findFirst().orElseThrow(() -> new IllegalArgumentException(CANNOT_FIND_NAME_ERROR));
	}

	private void validateDuplication(final List<Item> items) {
		Set<String> nonDuplicatedItems = items.stream()
			.map(Item::getName)
			.collect(Collectors.toSet());
		if (nonDuplicatedItems.size() < items.size()) {
			throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
		}
	}
}
