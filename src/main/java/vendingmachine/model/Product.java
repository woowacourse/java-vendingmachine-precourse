package vendingmachine.model;

import vendingmachine.util.ProductException;

public class Product {
	public String name;
	public int price;
	public int quantity;

	public Product(String productStr) {
		String[] productInfo = productStr.split(",", -1);

		ProductException.ProductInfoSize(productInfo);
	}
}
