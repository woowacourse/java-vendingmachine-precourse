package vendingmachine.model;

import vendingmachine.util.Utils;

public class Product {
	private String name;
	private int price;
	private int amount;

	public static Product createProduct(String productInformation) {
		Product product = new Product();
		productInformation = productInformation.replace("[", "").replace("]", "");
		String[] productInfo = productInformation.split(",");
		product.name = productInfo[0];
		product.price = Utils.moneyConverter(productInfo[1]);
		product.amount = Integer.parseInt(productInfo[2]);
		return product;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getAmount() {
		return this.amount;
	}

	public Product purchaseProduct() {
		this.amount--;
		return this;
	}
}
