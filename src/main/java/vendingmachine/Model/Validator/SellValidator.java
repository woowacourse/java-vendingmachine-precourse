package vendingmachine.Model.Validator;

import vendingmachine.Constants;
import vendingmachine.Controller.Run.Init;
import vendingmachine.Model.Product;

public class SellValidator {
	public Product product;

	public SellValidator(String name) {
		this.product = Init.products.find(name);
		validate();
	}

	private void validate() {
		isUserRich();
		isNoStock();
	}

	private void isUserRich() {
		if (product.PRICE > Init.userMoney) {
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}

	private void isNoStock() {
		if (product.stock == 0) {
			throw new IllegalArgumentException(Constants.ERROR);
		}
	}
}
