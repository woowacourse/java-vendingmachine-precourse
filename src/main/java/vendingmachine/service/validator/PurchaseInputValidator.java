package vendingmachine.service.validator;

import java.util.List;
import java.util.Objects;

import vendingmachine.domain.Item;

public class PurchaseInputValidator {

	public boolean validateItem(Item selectedItem, int remainingMoney) {
		try {
			isExistsItem(selectedItem);
			isEnoughItem(selectedItem);
			isEnoughMoney(selectedItem, remainingMoney);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	private void isExistsItem(Item selectedItem) {
		if (Objects.isNull(selectedItem)) {
			throw new IllegalArgumentException("존재하지 않는 상품명입니다.");
		}
	}

	private void isEnoughItem(Item selectedItem) {
		if (!selectedItem.isEnoughQuantity()) {
			throw new IllegalArgumentException("상품의 재고가 부족합니다.");
		}
	}

	private void isEnoughMoney(Item selectedItem, int remainingMoney) {
		if (!selectedItem.isEnoughMoneyForPurchasing(remainingMoney)) {
			throw new IllegalArgumentException("이 상품을 사기에는 금액이 부족합니다.");
		}
	}
}
