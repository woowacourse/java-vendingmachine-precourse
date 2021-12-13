package vendingmachine.model;

import vendingmachine.validation.ProductValidation;

public class Product {

	private final String name;
	private final int price;
	private int stock;

	public Product(String name, String price, String stock) {
		this.name = ProductValidation.productName(name);
		stock = ProductValidation.productStock(stock);
		ProductValidation.setProduct(price, stock);
		this.price = Integer.parseInt(price);
		this.stock = Integer.parseInt(stock);
	}

	public int getPrice() {
		return price;
	}

	public boolean isRemain() {
		return stock > 0;
	}

	public String getName() {
		return name;
	}

	public void reduceStock() {
		stock--;
	}
}
