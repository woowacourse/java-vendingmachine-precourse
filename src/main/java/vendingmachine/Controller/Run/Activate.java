package vendingmachine.Controller.Run;

import vendingmachine.Controller.InputController;
import vendingmachine.Model.Product;
import vendingmachine.View.OutputView;

public class Activate {
	private String nameInput;

	public Activate() {
		do {
			OutputView.printUserMoney(Init.userMoney);
			setWantedProduct();

			Product product = Init.products.find(nameInput);
			if (product.PRICE > Init.userMoney || product.stock == 0) {
				break;
			}

			//팔렸다
			Init.userMoney -= product.PRICE;
			product.sell();
		} while (!isActivateEnd());
	}

	private void setWantedProduct() {
		nameInput = InputController.setWantedProduct(Init.products.getNames());
		OutputView.printEmpty();
	}

	private boolean isActivateEnd() {
		return Init.userMoney < Init.products.getMinPrice() || Init.products.allSoldOut();
	}
}
