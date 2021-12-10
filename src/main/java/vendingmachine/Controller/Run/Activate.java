package vendingmachine.Controller.Run;

import vendingmachine.Controller.InputController;
import vendingmachine.Model.Product;
import vendingmachine.View.OutputView;

public class Activate {
	private String nameInput;

	// public Activate() {
	// 	do {
	// 		OutputView.printUserMoney(Init.userMoney);
	// 		setInputProduct();
	//
	// 		Product product = Init.products.find(nameInput);
	// 		if (product.PRICE > Init.userMoney || product.stock == 0) {
	// 			break;
	// 		}
	//
	// 		//팔렸다
	// 		sell(product);
	// 	} while (!isActivateEnd());
	// }

	public Activate() {
		repeatSell();
	}

	public void repeatSell() {
		OutputView.printUserMoney(Init.userMoney);
		setInputProduct();
		Product product = Init.products.find(nameInput);

		//팔렸다
		sell(product);
		if (!isActivateEnd()) {
			repeatSell();
		}
	}

	private void sell(Product product) {
		Init.userMoney -= product.PRICE;
		product.sell();
	}

	private void setInputProduct() {
		nameInput = InputController.setWantedProduct(Init.products.getNames());
		OutputView.printEmpty();
	}

	private boolean isActivateEnd() {
		return Init.userMoney < Init.products.getMinPrice() || Init.products.allSoldOut();
	}
}
