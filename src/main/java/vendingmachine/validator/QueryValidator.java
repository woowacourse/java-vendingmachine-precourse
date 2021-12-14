package vendingmachine.validator;

import static vendingmachine.constants.ErrorMessages.*;

import java.util.List;

public class QueryValidator {
	private static final QueryValidator queryValidator = new QueryValidator();

	private QueryValidator() {
	}

	public static QueryValidator getQueryValidator() {
		return queryValidator;
	}

	public void checkAllBuyItemErrorExceptions(String itemName, int remainingMoney, List<String> nameList, int price) {
		checkDontExistingItemExceptions(itemName, nameList);
		checkNotEnoughMoneyExceptions(remainingMoney, price);
	}

	private void checkNotEnoughMoneyExceptions(int remainingMoney, int price) {
		if (price > remainingMoney) {
			throw new IllegalArgumentException(DONT_HAVE_ENOUGH_MONEY_ERROR_MESSAGE);
		}
	}

	private void checkDontExistingItemExceptions(String itemName, List<String> nameList) {
		if (!nameList.contains(itemName)) {
			throw new IllegalArgumentException(DONT_EXISTING_ITEM_ERROR_MESSAGE);
		}
	}
}
