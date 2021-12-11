package vendingmachine.model;

import vendingmachine.utils.ExceptionUtils;

public class Product {

	private final String name;
	private final int price;
	private int number;
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int NUMBER_INDEX = 2;
	private static final int SOLD_OUT_COUNT = 0;
	private static final String PRODUCT_INFO_DELIMITER = ",";
	private static final String PRODUCT_BRACKET_LEFT = "[";
	private static final String PRODUCT_BRACKET_RIGHT = "]";

	public Product(String productInfo) {
		productInfo = ExceptionUtils.validateInputProductsInfo(productInfo);
		String[] info = removeBrackets(productInfo).split(PRODUCT_INFO_DELIMITER);
		this.name = info[NAME_INDEX];
		this.price = ExceptionUtils.validatePriceOfProductsInfo(
			Integer.parseInt(info[PRICE_INDEX]));
		this.number = ExceptionUtils.validateNumberOfProductsInfo(
			Integer.parseInt(info[NUMBER_INDEX]));
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getNumber() {
		return number;
	}

	public boolean isSoldOut() {
		return number == SOLD_OUT_COUNT;
	}

	public void sellProduct() {
		number--;
	}

	private String removeBrackets(String productInfo) {
		return productInfo
			.replace(PRODUCT_BRACKET_LEFT, "")
			.replace(PRODUCT_BRACKET_RIGHT, "");
	}
}
