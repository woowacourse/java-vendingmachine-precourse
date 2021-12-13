package vendingmachine.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import vendingmachine.domain.Item;
import vendingmachine.validator.ItemValidator;
import vendingmachine.validator.MoneyValidator;

public class InputConverter {

	private static final ItemValidator itemValidator = new ItemValidator();
	private static final MoneyValidator moneyValidator = new MoneyValidator();

	public static int convertMoney(String input) {
		int money = moneyValidator.isInteger(input);

		moneyValidator.validateMoney(money);

		return money;
	}

	public static int convertUserMoney(String input) {
		int money = convertMoney(input);

		itemValidator.validateMoneyByItemMinPrice(money);

		return money;
	}

	public static List<Item> convertItems(String input) {
		List<Item> items = new ArrayList<>();

		Stream.of(input.split(";"))
			.forEach(item ->
				items.add(itemValidator.validateName(
					itemValidator.isRightFormalOfItem(
						itemValidator.isInSquareBracket(item)), items)));

		return items;
	}

	public static Item convertItemName(String input, int money) {
		Item item = itemValidator.validateItemName(input, money);

		return item;
	}
}
