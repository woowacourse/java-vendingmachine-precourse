package vendingmachine.verification;

import static vendingmachine.NumberConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import vendingmachine.domain.Item;

public class Verification {

	private static final ItemValidator itemValidator = new ItemValidator();

	private static final String NOT_INTEGER_ERROR = "[ERROR] 입력값이 숫자여야 합니다.\n";
	private static final String NOT_MULTIPLE_OF_TEN_ERROR = "[ERROR] 금액은 10원 단위여야 합니다.\n";

	private static final String INTEGER = "-?\\d+";

	public static int ofMoney(String input) {
		int money = isInteger(input);

		if (money <= ZERO || money % TEN != ZERO) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_ERROR);
		}

		return money;
	}

	public static int isInteger(String input) {
		if (!input.matches(INTEGER)) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR);
		}

		return Integer.parseInt(input);
	}

	public static int ofUserMoney(String input) {
		int money = ofMoney(input);

		itemValidator.validateMoneyByItemMinPrice(money);

		return money;
	}

	public static List<Item> ofItems(String input) {
		List<Item> items = new ArrayList<>();

		Stream.of(input.split(";"))
			.forEach(item ->
				items.add(itemValidator.isRightFormalOfItem(itemValidator.isInSquareBracket(item))));

		return items;
	}

	public static Item ofItemName(String input, int money) {
		Item item = itemValidator.validateItemName(input, money);

		return item;
	}
}
