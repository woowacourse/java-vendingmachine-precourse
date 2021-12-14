package model;

public class Product {
	private static final int MIN_STOCK_COUNT = 1;
	private static final int MINUS_STOCK_COUNT = 1;
	private static final int NO_STOCK_COUNT = 0;
	private static final String NO_PRODUCT_STOCK_ERROR_MESSAGE = "[ERROR] 입력한 구매 상품명의 상품 재고가 없다.";

	private final String name;
	private final int price;
	private int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void reduceStock() {
		if (stock < MIN_STOCK_COUNT) {
			throw new IllegalArgumentException(NO_PRODUCT_STOCK_ERROR_MESSAGE);
		}
		stock -= MINUS_STOCK_COUNT;
	}

	public boolean isSoldOut() {
		return stock == NO_STOCK_COUNT;
	}

	public boolean hasSameName(String productName) {
		return name.equals(productName);
	}
}
