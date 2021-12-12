package vendingmachine.domain.user;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductName;
import vendingmachine.domain.product.Products;
import vendingmachine.validator.AmountValidator;

public class User {
	private int amount;

	public User(String amount) {
		AmountValidator.checkUserAmount(amount);
		this.amount = Integer.parseInt(amount);
	}

	@Override
	public String toString() {
		return "투입 금액: " + this.amount + "원";
	}

	public void buyProduct(Products products, String inputProductName) {
		ProductName productName = new ProductName(inputProductName);
		Product product = products.getProductByName(productName);
		product.sell(this.amount);
		amount = product.getChange(amount);
	}
}
