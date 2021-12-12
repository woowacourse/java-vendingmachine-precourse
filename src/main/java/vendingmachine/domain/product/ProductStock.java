package vendingmachine.domain.product;

import vendingmachine.validator.ProductValidator;

public class ProductStock {
	private int stock;

	public ProductStock(int stock) {
		ProductValidator.checkProductStock(stock);
		this.stock = stock;
	}
}
