package vendingmachine.model;

import vendingmachine.validation.VendingMachineValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class VendingMachine {

	Wallet wallet;
	ProductList productList;

	public VendingMachine() {
		wallet = new Wallet();
		productList = new ProductList();
	}

	public boolean isRemainProduct() {
		return productList.isRemainProduct();
	}

	public boolean canBuy(User user) {
		int minPrice = productList.getRemainMinPrice();
		return user.canBuy(minPrice);
	}

	public void buyProduct(User user) {
		String name = InputView.buyProduct();
		Product product = null;
		try {
			 product = VendingMachineValidation.buyProduct(productList, name, user);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.illegalArgumentException(illegalArgumentException.getMessage());
			buyProduct(user);
		}
		product.reduceStock();
		user.buyProduct(product.getPrice());
	}

}
