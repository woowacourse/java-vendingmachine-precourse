package vendingmachine.domain.product;

import vendingmachine.validator.ProductValidator;

public class ProductStock {
	private int stock;

	private ProductStock() {
		this.stock = 0;
	}

	public ProductStock(int stock) {
		ProductValidator.checkProductStock(stock);
		this.stock = stock;
	}

	public ProductStock subtract() {
		if (isLastStock()) {
			return new ProductStock();
		}
		return new ProductStock(stock - 1);
	}

	private boolean isLastStock() {
		return this.stock == 1;
	}

	public boolean isPositive() {
		return this.stock > 0;
	}
}
