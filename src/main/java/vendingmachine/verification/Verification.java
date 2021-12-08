package vendingmachine.verification;

import static vendingmachine.NumberConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import vendingmachine.domain.Item;
import vendingmachine.service.ItemService;

public class Verification {

	private static final ItemService itemService = new ItemService();

	private static final String NOT_INTEGER_ERROR = "[ERROR] 입력값이 숫자여야 합니다.\n";
	private static final String NOT_MULTIPLE_OF_TEN_ERROR = "[ERROR] 금액은 10원 단위여야 합니다.\n";
	private static final String NOT_IN_SQUARE_BRACKET_ERROR = "[ERROR] 상품은 대괄호 안에서 입력해야 합니다.\n";
	private static final String NOT_MATCH_NUMBER_ERROR = "[ERROR] 상품 속성은 3개여야 합니다.\n";
	private static final String PRICE__ERROR = "[ERROR] 가격은 100원 이상이고 10원 단위여야 합니다.\n";
	private static final String STOCK_QUANTITY__ERROR = "[ERROR] 수량은 1개 이상이어야 합니다.\n";
	private static final String NOT_SUFFICIENT_MONEY_ERROR = "[ERROR] 투입 금액은 상품 최저 금액보다 같거나 커야 합니다.\n";
	private static final String NOT_EXIST_ITEM_ERROR = "[ERROR] 등록된 상품만 구매 가능합니다.\n";
	private static final String NO_SUFFICIENT_QUANTITY_ERROR = "[ERROR] 상품 수량이 없습니다.\n";
	private static final String NO_SUFFICIENT_MONEY_THEN_PRICE_ERROR = "[ERROR] 남아 있는 투입 금액부족합니다.\n";

	private static final String INTEGER = "-?\\d+";

	public static int ofMoney(String input) {
		int money = isInteger(input);

		if (money <= ZERO || money % TEN != ZERO) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_ERROR);
		}

		return money;
	}

	private static int isInteger(String input) {
		if (!input.matches(INTEGER)) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR);
		}

		return Integer.parseInt(input);
	}

	public static int ofUserMoney(String input) {
		int money = ofMoney(input);

		if (money < itemService.getMinPrice()) {
			throw new IllegalArgumentException(NOT_SUFFICIENT_MONEY_ERROR);
		}

		return money;
	}

	public static List<Item> ofItems(String input) {
		List<Item> items = new ArrayList<>();

		Stream.of(input.split(";"))
			.forEach(item ->
				items.add(isRightFormalOfItem(isInSquareBracket(item))));

		return items;
	}

	private static String isInSquareBracket(String item) {
		if (item.startsWith("[") && item.endsWith("]")) {
			return item.replaceFirst("\\[", "")
				.replaceFirst("]", "");
		}

		throw new IllegalArgumentException(NOT_IN_SQUARE_BRACKET_ERROR);
	}

	private static Item isRightFormalOfItem(String item) {
		String[] attributes = item.split(",");

		if (attributes.length != THREE) {
			throw new IllegalArgumentException(NOT_MATCH_NUMBER_ERROR);
		}

		String name = attributes[ZERO];
		int price = validatePrice(attributes[ONE]);
		int stockQuantity = validateStockQuantity(attributes[TWO]);

		return new Item(name, price, stockQuantity);
	}

	private static int validatePrice(String priceInput) {
		int price = isInteger(priceInput);

		if (price < HUNDRED || price % TEN != ZERO) {
			throw new IllegalArgumentException(PRICE__ERROR);
		}

		return price;
	}

	private static int validateStockQuantity(String stockQuantityInput) {
		int stockQuantity = isInteger(stockQuantityInput);

		if (stockQuantity <= ZERO) {
			throw new IllegalArgumentException(STOCK_QUANTITY__ERROR);
		}

		return stockQuantity;
	}

	public static Item ofItemName(String input, int money) {
		Item item = itemService.findByName(input);

		if (item == null) {
			throw new IllegalArgumentException(NOT_EXIST_ITEM_ERROR);
		}

		if (!item.isAvailableToBuy()) {
			throw new IllegalArgumentException(NO_SUFFICIENT_QUANTITY_ERROR);
		}

		if (!item.isAvailableToBuy(money)) {
			throw new IllegalArgumentException(NO_SUFFICIENT_MONEY_THEN_PRICE_ERROR);
		}

		return item;
	}
}
