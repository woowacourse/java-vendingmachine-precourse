package vendingmachine.Utils.Validator;

import vendingmachine.Model.Product;
import vendingmachine.Utils.Constants;

public class SellValidator {
	public Product product;

	public SellValidator(Product product, int userMoney) {
		this.product = product;
		isUserRich(userMoney);
		isNoStock();
	}

	private void isUserRich(int userMoney) {
		if (product.PRICE > userMoney) {
			throw new IllegalArgumentException(Constants.ERROR_USER_POOR);
		}
	}

	private void isNoStock() {
		if (product.isSoldOut()) {
			throw new IllegalArgumentException(Constants.ERROR_NO_STOCK);
		}
	}
}
