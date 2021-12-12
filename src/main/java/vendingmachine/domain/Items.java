package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {
	private static final String START_OR_END_WITH_BRACKET = "[ERROR] 상품 정보는 대괄호로 감싸져 있어야 합니다.";

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
}
