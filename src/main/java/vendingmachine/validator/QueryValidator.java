package vendingmachine.validator;

import static vendingmachine.constants.ErrorMessages.*;

import java.util.Objects;

import vendingmachine.resource.ItemStorage;

public class QueryValidator {
	private static final QueryValidator queryValidator = new QueryValidator();

	private final ItemStorage itemStorage;

	private QueryValidator() {
		itemStorage = ItemStorage.getItemStorage();
	}

	public static QueryValidator getQueryValidator() {
		return queryValidator;
	}

	public boolean checkBuyItemErrorExceptions(String purchasingItem, int remainingMoney) {
		try {
			checkAllBuyItemErrorExceptions(purchasingItem, remainingMoney);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkAllBuyItemErrorExceptions(String purchasingItem, int remainingMoney) {
		checkDontExistingItemExceptions(purchasingItem);
		checkNotEnoughMoneyExceptions(purchasingItem, remainingMoney);
	}

	private void checkNotEnoughMoneyExceptions(String purchasingItem, int remainingMoney) {
		if (itemStorage.getPriceByName(purchasingItem) > remainingMoney) {
			throw new IllegalArgumentException(DONT_HAVE_ENOUGH_MONEY_ERROR_MESSAGE);
		}
	}

	private void checkDontExistingItemExceptions(String purchasingItem) {
		if (!hasItemNamed(purchasingItem)) {
			throw new IllegalArgumentException(DONT_EXISTING_ITEM_ERROR_MESSAGE);
		}
	}

	private boolean hasItemNamed(String purchasingItem) {
		return itemStorage.getNameList().stream()
			.anyMatch(item -> Objects.equals(item, purchasingItem));
	}
}
