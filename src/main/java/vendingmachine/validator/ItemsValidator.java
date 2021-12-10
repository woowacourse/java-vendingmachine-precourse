package vendingmachine.validator;

import java.util.Arrays;

import vendingmachine.domain.item.Item;
import vendingmachine.exception.DataDuplicatedException;

public class ItemsValidator extends Validator {
	private static final String SPLIT_DELIMITER = ";";

	// TODO: 리팩토링 필요
	public static void validateItemsInputFormat(String input) {
		int originalCount = input.split(SPLIT_DELIMITER).length;
		boolean duplicated = Arrays.stream(input.split(SPLIT_DELIMITER))
			.map(Item::from)
			.map(Item::getItemName)
			.distinct()
			.count() != originalCount;

		if (duplicated) {
			throw new DataDuplicatedException();
		}
	}
}
