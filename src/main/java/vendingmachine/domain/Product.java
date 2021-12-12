package vendingmachine.domain;

import java.util.List;

public class Product {
	private String name;
	private int price;
	private int amount;
	private enum ProductIdx { NAME, PRICE, AMOUNT }

	public Product(List<String> productInfo) {
		this.name = productInfo.get(ProductIdx.NAME.ordinal());
		this.price = Integer.parseInt(productInfo.get(ProductIdx.PRICE.ordinal()));
		this.amount = Integer.parseInt(productInfo.get(ProductIdx.AMOUNT.ordinal()));
	}
}
