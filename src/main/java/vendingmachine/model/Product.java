package vendingmachine.model;

import vendingmachine.util.SymbolConstants;

public class Product {
	private static final int FIRST_INDEX = 0;
	private static final int SECOND_INDEX = 1;
	private static final int THIRD_INDEX = 2;
	private static final int TEN = 10;
	private static final int HUNDRED = 100;
	private final String name;
	private final int price;
	private int quantity;

	public Product(String[] productDetail) {
		this.name = productDetail[FIRST_INDEX];
		this.price = Integer.parseInt(productDetail[SECOND_INDEX]);
		this.quantity = Integer.parseInt(productDetail[THIRD_INDEX]);
	}

	public boolean equalProductName(String name) {
		return this.name.equals(name);
	}


	public boolean exists() {
		return this.quantity > SymbolConstants.ZERO;
	}

	public int compareMinimumPrice(int minimumPrice) {
		return Math.min(this.price, minimumPrice);
	}

	public void purchase() {
		this.quantity--;
	}

	public int subtractProductPrice(int insertMoney) {
		return insertMoney - this.price;
	}

	public boolean isPriceOverHundred() {
		return this.price >= HUNDRED;
	}

	public boolean isPriceDividedByTen() {
		return (this.price % TEN) == SymbolConstants.ZERO;
	}
}
