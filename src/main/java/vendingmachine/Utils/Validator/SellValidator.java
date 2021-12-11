package vendingmachine.Utils.Validator;

import vendingmachine.Model.Beverage;
import vendingmachine.Utils.Constants;

public class SellValidator {
	public Beverage beverage;

	public SellValidator(Beverage beverage, int userMoney) {
		this.beverage = beverage;
		isUserRich(userMoney);
		isNoStock();
	}

	private void isUserRich(int userMoney) {
		if (beverage.price > userMoney) {
			throw new IllegalArgumentException(Constants.ERROR_USER_POOR);
		}
	}

	private void isNoStock() {
		if (beverage.isSoldOut()) {
			throw new IllegalArgumentException(Constants.ERROR_NO_STOCK);
		}
	}
}
