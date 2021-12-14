package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {
	private static final String START_OR_END_WITH_BRACKET = "[ERROR] 상품 정보는 대괄호로 감싸져 있어야 합니다.";
	private static final String FIND_NO_ITEM = "[ERROR] 상품이 존재하지 않습니다.";

	private final List<Item> itemRepository;

	public Items(String input) {
		itemRepository = new ArrayList<>();
		String[] data = input.split(";");
		validate(data);
		for (String itemData : data) {
			checkBracket(itemData);
			saveItem(createItem(removeBracket(itemData)));
		}
	}

	private Item createItem(String itemData) {
		return new Item(itemData.split(","));
	}

	private void saveItem(Item item) {
		itemRepository.add(item);
	}

	private void validate(String[] data) {
		Arrays.stream(data).forEach(this::checkBracket);
	}

	private void checkBracket(String itemData) {
		if (!itemData.startsWith("[") || !itemData.endsWith("]")) {
			throw new IllegalArgumentException(START_OR_END_WITH_BRACKET);
		}
	}

	private String removeBracket(String itemData) {
		return itemData.replace("[", "").replace("]", "");
	}

	public int purchase(String itemName, int money) {
		Item item = find(itemName);
		return item.purchase(money);
	}

	private Item find(String name) {
		return itemRepository.stream().filter(item -> item.equals(name)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException(FIND_NO_ITEM));
	}

	public boolean continuable(int moneyLeft) {
		/* 남은 돈으로 살 수 있는 상품이 없거나 모든 상품 재고가 없으면 진행이 불가능 */
		return enoughMoneyForAllItem(moneyLeft) && quantityLeft();
	}

	private boolean enoughMoneyForAllItem(int moneyLeft) {
		return itemRepository.stream().anyMatch(item -> item.enoughMoney(moneyLeft));
	}

	private boolean quantityLeft() {
		return itemRepository.stream().anyMatch(Item::quantityLeft);
	}
}
