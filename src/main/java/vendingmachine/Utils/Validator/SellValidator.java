package vendingmachine.Utils.Validator;

import vendingmachine.Model.Beverage;
import vendingmachine.Model.Money;
import vendingmachine.Utils.Constants;

public class SellValidator {
	public Beverage beverage;

	public SellValidator(Beverage beverage, Money userMoney) {
		this.beverage = beverage;
		isUserRich(userMoney);
		isSoldOut();
	}

	private void isUserRich(Money userMoney) {
		if (beverage.price > userMoney.get()) {
			throw new IllegalArgumentException(Constants.ERROR_USER_POOR);
		}
	}

	private void isSoldOut() {
		if (beverage.isSoldOut()) {
			throw new IllegalArgumentException(Constants.ERROR_NO_STOCK);
		}
	}
}
