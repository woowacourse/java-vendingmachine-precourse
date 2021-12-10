package vendingmachine.Model.Validator;

import vendingmachine.Constants;
import vendingmachine.Controller.MachineController;
import vendingmachine.Model.Product;

public class SellValidator {
	public Product product;

	public SellValidator(String name) {
		this.product = MachineController.init.products.find(name);
		validate();
	}

	private void validate() {
		isUserRich();
		isNoStock();
	}

	private void isUserRich() {
		if (product.PRICE > MachineController.userMoney) {
			throw new IllegalArgumentException(Constants.ERROR_USER_POOR);
		}
	}

	private void isNoStock() {
		if (product.isSoldOut()) {
			throw new IllegalArgumentException(Constants.ERROR_NO_STOCK);
		}
	}
}
