package vendingmachine.verification;

import static vendingmachine.NumberConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import vendingmachine.domain.Item;

public class Verification {

	private static final String NOT_INTEGER_ERROR = "[ERROR] 입력값이 숫자여야 합니다.\n";
	private static final String NOT_MULTIPLE_OF_TEN_ERROR = "[ERROR] 금액은 10원 단위여야 합니다.\n";
	private static final String NOT_IN_SQUARE_BRACKET_ERROR = "[ERROR] 상품은 대괄호 안에서 입력해야 합니다.\n";
	private static final String NOT_MATCH_NUMBER_ERROR = "[ERROR] 상품 속성은 3개여야 합니다.\n";
	private static final String PRICE__ERROR = "[ERROR] 가격은 100원 이상이고 10원 단위여야 합니다..\n";
	private static final String STOCK_QUANTITY__ERROR = "[ERROR] 수량은 1개 이상이어야 합니다..\n";

	private static final String INTEGER = "-?\\d+";

	public static int ofMoney(String input) throws IllegalArgumentException{
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
			throw new IllegalArgumentException(stockQuantityInput);
		}

		return stockQuantity;
	}
}
