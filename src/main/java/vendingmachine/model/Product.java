package vendingmachine.model;

public class Product {
	private final String name;
	private final int price;
	private int quantity;

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(String[] productDetail) {
		this.name = productDetail[0];
		this.price = Integer.parseInt(productDetail[1]);
		this.quantity = Integer.parseInt(productDetail[2]);
	}

	public boolean equalProductName(String name) {
		return this.name.equals(name);
	}


	public boolean exists() {
		return this.quantity > 0;
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
		return this.price >= 100;
	}

	public boolean isPriceDividedByTen() {
		return (this.price % 10) == 0;
	}
}
