package vendingmachine.domain.product;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.constant.SystemMessage.*;

import vendingmachine.validator.AmountValidator;
import vendingmachine.validator.ProductValidator;

public class Product implements Comparable<Product> {
	private ProductName name;
	private ProductAmount amount;
	private ProductStock stock;

	public Product(String unprocessedProduct) {
		ProductValidator.checkProduct(unprocessedProduct);
		String[] processedProduct = unprocessedProduct.substring(1, unprocessedProduct.length() - 1)
			.split(NAME_COST_STOCK_DELIMITER);
		int amount = AmountValidator.toInteger(processedProduct[AMOUNT]);
		int stock = AmountValidator.toInteger(processedProduct[STOCK]);

		this.name = new ProductName(processedProduct[NAME]);
		this.amount = new ProductAmount(amount);
		this.stock = new ProductStock(stock);
	}

	public boolean equals(Product o) {
		return name.equals(o.name);
	}

	public boolean hasName(ProductName productName) {
		return name.equals(productName);
	}

	public boolean hasStock() {
		return stock.isPositive();
	}

	public boolean canBeSold(int userAmount) {
		return !amount.isExpensive(userAmount);
	}

	public void sell(int userAmount) {
		if (amount.isExpensive(userAmount)) {
			throw new IllegalArgumentException(PRODUCT_IS_EXPENSIVE_ERROR_MESSAGE);
		}
		stock = stock.subtract();
	}

	public int getChange(int userAmount) {
		return amount.getChange(userAmount);
	}

	@Override
	public int compareTo(Product other) {
		return amount.compareTo(other.amount);
	}
}
