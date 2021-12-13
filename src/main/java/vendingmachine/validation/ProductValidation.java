package vendingmachine.validation;

import static vendingmachine.constant.Constants.*;
import static vendingmachine.constant.ErrorMessage.*;

public class ProductValidation {

	public static void setProduct(String price, String stock) {
		UtilValidation.isNumber(price);
		UtilValidation.isNumber(stock);
		int priceInt = Integer.parseInt(price);
		int stockInt = Integer.parseInt(stock);
		UtilValidation.isNaturalNumber(priceInt);
		UtilValidation.isNaturalNumber(stockInt);
		UtilValidation.canDivideMinCoin(priceInt);
		UtilValidation.isUpperNumber(MIN_PRICE, priceInt);
	}

	public static void productParsingNumber(int length) {
		if (length != 3) {
			throw new IllegalArgumentException(ERROR_PRODUCT_FORM);
		}
	}

	public static String productName(String name) {
		if (!name.contains(PRODUCT_START)) {
			throw new IllegalArgumentException(ERROR_PRODUCT_FORM);
		}
		return name.substring(1);
	}

	public static String productStock(String stock) {
		if (!stock.contains(PRODUCT_END)) {
			throw new IllegalArgumentException(ERROR_PRODUCT_FORM);
		}
		return stock.substring(0,stock.length()-1);
	}
}
