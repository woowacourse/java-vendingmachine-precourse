package vendingmachine.domain;

public class Product {

	private String productName;
	private int price;
	private int remains;

	Product(String productName, int price, int remains) {
		this.productName = productName;
		this.price = price;
		this.remains = remains;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}

	public int reduceRmains() {
		return --remains;
	}

}
