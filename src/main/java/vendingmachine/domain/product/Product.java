package vendingmachine.domain.product;

import static vendingmachine.constant.ErrorMessage.*;

public class Product implements Comparable<Product> {
	private ProductName name;
	private ProductAmount amount;
	private ProductStock stock;

	public Product(ProductName name, ProductAmount amount, ProductStock stock) {
		this.name = name;
		this.amount = amount;
		this.stock = stock;
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
