package vendingmachine.validator;

import static vendingmachine.NumberConstant.*;

import java.util.List;
import java.util.Optional;

import vendingmachine.domain.Item;
import vendingmachine.service.ItemService;

public class ItemValidator {

	private static final ItemService itemService = new ItemService();
	private static final MoneyValidator moneyValidator = new MoneyValidator();

	private static final String NOT_SUFFICIENT_MONEY_ERROR = "[ERROR] 투입 금액은 상품 최저 금액보다 같거나 커야 합니다.\n";
	private static final String NOT_IN_SQUARE_BRACKET_ERROR = "[ERROR] 상품은 대괄호 안에서 입력해야 합니다.\n";
	private static final String NOT_MATCH_NUMBER_ERROR = "[ERROR] 상품 속성은 3개여야 합니다.\n";
	private static final String PRICE__ERROR = "[ERROR] 가격은 100원 이상이고 10원 단위여야 합니다.\n";
	private static final String STOCK_QUANTITY__ERROR = "[ERROR] 수량은 1개 이상이어야 합니다.\n";
	private static final String NOT_EXIST_ITEM_ERROR = "[ERROR] 등록된 상품만 구매 가능합니다.\n";
	private static final String NO_SUFFICIENT_QUANTITY_ERROR = "[ERROR] 상품 수량이 없습니다.\n";
	private static final String NO_SUFFICIENT_MONEY_THEN_PRICE_ERROR = "[ERROR] 남아 있는 투입 금액부족합니다.\n";
	private static final String SAME_NAME_INPUT_ERROR = "[ERROR] 같은 이름의 상품을 여러개 등록할 수 없습니다.\n";

	public void validateMoneyByItemMinPrice(int money) {
		if (!itemService.haveAnyItemToBuy(money)) {
			throw new IllegalArgumentException(NOT_SUFFICIENT_MONEY_ERROR);
		}
	}

	public Item validateItem(String input, List<Item> items) {
		String inputWithOitBlanket = isInSquareBracket(input);
		Item item = isRightFormalOfItem(inputWithOitBlanket);
		return validateDuplicateName(item, items);
	}

	private String isInSquareBracket(String item) {
		if (item.startsWith("[") && item.endsWith("]")) {
			return item.replaceFirst("\\[", "")
				.replaceFirst("]", "");
		}

		throw new IllegalArgumentException(NOT_IN_SQUARE_BRACKET_ERROR);
	}

	private Item isRightFormalOfItem(String item) {
		String[] attributes = item.split(",");

		if (attributes.length != THREE) {
			throw new IllegalArgumentException(NOT_MATCH_NUMBER_ERROR);
		}

		String name = attributes[ZERO];
		int price = validatePrice(attributes[ONE]);
		int stockQuantity = validateStockQuantity(attributes[TWO]);

		return new Item(name, price, stockQuantity);
	}

	private Item validateDuplicateName(Item item, List<Item> items) {
		Optional<Item> findItem = items.stream()
			.filter(i -> i.isName(item))
			.findFirst();

		if (findItem.isPresent()) {
			throw new IllegalArgumentException(SAME_NAME_INPUT_ERROR);
		}

		return item;
	}

	private int validatePrice(String priceInput) {
		int price = moneyValidator.isInteger(priceInput);

		if (price < HUNDRED || price % TEN != ZERO) {
			throw new IllegalArgumentException(PRICE__ERROR);
		}

		return price;
	}

	private int validateStockQuantity(String stockQuantityInput) {
		int stockQuantity = moneyValidator.isInteger(stockQuantityInput);

		if (stockQuantity <= ZERO) {
			throw new IllegalArgumentException(STOCK_QUANTITY__ERROR);
		}

		return stockQuantity;
	}

	public Item validateItemName(String input, int money) {
		Item item = itemService.findByName(input);

		if (item == null) {
			throw new IllegalArgumentException(NOT_EXIST_ITEM_ERROR);
		}

		if (!item.isAvailableToBuy(money)) {
			throw new IllegalArgumentException(NO_SUFFICIENT_MONEY_THEN_PRICE_ERROR);
		}
		return item;
	}
}
