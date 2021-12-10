package vendingmachine.Controller.Run;

import vendingmachine.Controller.InputController;
import vendingmachine.Model.Product;
import vendingmachine.View.OutputView;

public class Activate {
	private String nameInput;

	public Activate() {
		repeatSell();
	}

	public void repeatSell() {
		OutputView.printUserMoney(Init.userMoney);
		setNameInput();
		OutputView.printEmpty();

		sell(Init.products.find(nameInput));
		if (!isActivateEnd()) {
			repeatSell();
		}
	}

	private void sell(Product product) {
		Init.userMoney -= product.PRICE;
		product.sell();
	}

	private void setNameInput() {
		nameInput = InputController.setWantedProduct(Init.products.getNames());
	}

	private boolean isActivateEnd() {
		return Init.userMoney < Init.products.getMinPrice() || Init.products.allSoldOut();
	}
}
