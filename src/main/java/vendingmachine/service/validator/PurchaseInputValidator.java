package vendingmachine.service.validator;

import java.util.List;
import java.util.Objects;

import vendingmachine.domain.Item;

public class PurchaseInputValidator {

	public void validateItem(Item selectedItem) {
		try {
			isExistsItem(selectedItem);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void isExistsItem(Item selectedItem) {
		if (Objects.isNull(selectedItem)) {
			throw new IllegalArgumentException("존재하지 않는 상품명입니다.");
		}
	}
}
