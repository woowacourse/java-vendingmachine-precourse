package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		try {
			return itemRepository.stream().filter(item -> item.equals(name)).collect(Collectors.toList()).get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(FIND_NO_ITEM);
		}
	}

	public boolean continuable(int moneyLeft) {
		return enoughMoneyForAllItem(moneyLeft) && quantityLeft();
	}

	private boolean enoughMoneyForAllItem(int moneyLeft) {
		return itemRepository.stream().anyMatch(item -> item.enoughMoney(moneyLeft));
	}

	private boolean quantityLeft() {
		return itemRepository.stream().anyMatch(Item::quantityLeft);
	}
}
