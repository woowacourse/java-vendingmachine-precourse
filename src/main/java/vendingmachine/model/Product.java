package vendingmachine.model;

import vendingmachine.utils.exception.ProductException;

public class Product {

	private final String productInfo;
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
		this.productInfo = productInfo;
		String[] filteredInfo = filterInfo();
		ProductException.validateFilteredInfo(filteredInfo);
		this.name = filteredInfo[NAME_INDEX];
		this.price = Integer.parseInt(filteredInfo[PRICE_INDEX]);
		this.number = Integer.parseInt(filteredInfo[NUMBER_INDEX]);
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

	public void takeOutProduct() {
		number--;
	}

	private String removeBrackets(String productInfo) {
		return productInfo
			.replace(PRODUCT_BRACKET_LEFT, "")
			.replace(PRODUCT_BRACKET_RIGHT, "");
	}

	private String[] filterInfo() {
		ProductException.validateInputProductsInfo(productInfo);
		return removeBrackets(productInfo).split(PRODUCT_INFO_DELIMITER);
	}
}
