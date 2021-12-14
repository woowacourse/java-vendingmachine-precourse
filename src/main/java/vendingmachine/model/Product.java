package vendingmachine.model;

import java.util.regex.Pattern;

import vendingmachine.util.Constant;
import vendingmachine.util.Utils;
import vendingmachine.validator.Validator;

public class Product {
	private String name;
	private int price;
	private int amount;

	public static Product createProduct(String productInformation) throws IllegalArgumentException {
		Product product = new Product();
		productInformation = productInformation.replace(Constant.OPEN_SQUARE_BRACKET, "").replace(Constant.CLOSING_SQUARE_BRACKET, "");
		String[] productInfo = productInformation.split(Constant.PRODUCT_DETAIL_SEPARATOR);

		Validator.validateProduct(productInfo);

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
