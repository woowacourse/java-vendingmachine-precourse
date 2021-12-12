package vendingmachine.service.validator;

import java.util.Objects;

import vendingmachine.domain.Item;
import vendingmachine.view.OutputView;
import vendingmachine.view.messages.ErrorMessage;

public class PurchaseInputValidator {

	public boolean validateItem(Item selectedItem, int remainingMoney) {
		try {
			isExistsItem(selectedItem);
			isEnoughItem(selectedItem);
			isEnoughMoney(selectedItem, remainingMoney);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	private void isExistsItem(Item selectedItem) {
		if (Objects.isNull(selectedItem)) {
			throw new IllegalArgumentException(ErrorMessage.ITEM_NOT_EXIST_EXCEPTION);
		}
	}

	private void isEnoughItem(Item selectedItem) {
		if (!selectedItem.isEnoughQuantity()) {
			throw new IllegalArgumentException(ErrorMessage.ITEM_EMPTY_QUANTITY_EXCEPTION);
		}
	}

	private void isEnoughMoney(Item selectedItem, int remainingMoney) {
		if (!selectedItem.isEnoughMoneyForPurchasing(remainingMoney)) {
			throw new IllegalArgumentException(ErrorMessage.PURCHASE_NOT_ENOUGH_MONEY_EXCEPTION);
		}
	}
}
