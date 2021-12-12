package vendingmachine.util;

import vendingmachine.message.Error;
import vendingmachine.model.Product;

import static vendingmachine.message.Error.WRONG_INFO_FORMAT;

public class ProductBuilder {
	private static final String LEFT_BRACKET = "[";
	private static final String RIGHT_BRACKET = "]";
	private static final String INFO_DELIM = ",";
	private static final int INFO_NAME_INDEX = 0;
	private static final int INFO_PRICE_INDEX = 1;
	private static final int INFO_STOCK_INDEX = 2;

	public Product makeProductFromInfo(String rawInfo) {
		String[] info;
		try {
			info = rawInfo.replace(LEFT_BRACKET, "").replace(RIGHT_BRACKET, "").split(INFO_DELIM);
			validateInfoArr(info);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(WRONG_INFO_FORMAT);
		}
		return new Product(info[INFO_NAME_INDEX], Integer.parseInt(info[INFO_PRICE_INDEX]), Integer.parseInt(info[INFO_STOCK_INDEX]));
	}

	private void validateInfoArr(String[] info) {
		validatePrice(info[INFO_PRICE_INDEX]);
		validateStock(info[INFO_STOCK_INDEX]);
	}

	private void validatePrice(String priceString) {
		if (!CommonValidator.isOnlyNums(priceString)) {
			throw new IllegalArgumentException(Error.NOT_ONLY_NUMS_IN_PRICE);
		}
		if (!ProductInfoValidator.aboveMinimumPrice(priceString)) {
			throw new IllegalArgumentException(Error.LESS_THEN_MINIMUM_PRICE);
		}
		if (!CommonValidator.rightMinimumUnit(priceString)) {
			throw new IllegalArgumentException(Error.WRONG_PRICE_UNIT);
		}
	}

	private void validateStock(String stockString) {
		if (!CommonValidator.isOnlyNums(stockString)) {
			throw new IllegalArgumentException(Error.NOT_ONLY_NUMS_IN_STOCK);
		}
	}
}
