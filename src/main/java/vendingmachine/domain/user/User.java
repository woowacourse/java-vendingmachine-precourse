package vendingmachine.domain.user;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductName;
import vendingmachine.domain.product.Products;
import vendingmachine.validator.AmountValidator;

public class User {
	private int amount;

	public User(int amount) {
		AmountValidator.checkUserAmount(amount);
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "투입 금액: " + this.amount + "원";
	}

	public boolean canBuyProduct(Products products) {
		if (!hasAnyProducts(products)) {
			return false;
		}
		return canBuyCheapestProduct(products);
	}

	private boolean hasAnyProducts(Products products) {
		return products.hasAnyProducts();
	}

	private boolean canBuyCheapestProduct(Products products) {
		Product cheapestProduct = products.getCheapestProduct();
		return cheapestProduct.canBeSold(this.amount);
	}

	public void buyProduct(Products products, String inputProductName) {
		ProductName productName = new ProductName(inputProductName);
		Product product = products.getProductByName(productName);
		product.sell(this.amount);
		amount = product.getChange(amount);
	}

	public int getAmount() {
		return this.amount;
	}
}
