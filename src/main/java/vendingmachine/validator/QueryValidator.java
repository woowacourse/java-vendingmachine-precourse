package vendingmachine.validator;

import static vendingmachine.constants.ErrorMessages.*;

public class QueryValidator {
	private static final QueryValidator queryValidator = new QueryValidator();

	private QueryValidator() {
	}

	public static QueryValidator getQueryValidator() {
		return queryValidator;
	}

	public void checkAllBuyItemErrorExceptions(int remainingMoney, int price) {
		checkNotEnoughMoneyExceptions(remainingMoney, price);
	}

	private void checkNotEnoughMoneyExceptions(int remainingMoney, int price) {
		if (price > remainingMoney) {
			throw new IllegalArgumentException(DONT_HAVE_ENOUGH_MONEY_ERROR_MESSAGE);
		}
	}
}
