package vendingmachine.validation;

import static vendingmachine.constant.Constants.*;

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
			throw new IllegalArgumentException("상품의 입력 폼이 올바르지 않습니다.");
		}
	}

	public static String productName(String name) {
		if (!name.contains("[")) {
			throw new IllegalArgumentException("상품의 입력 폼이 올바르지 않습니다.");
		}
		return name.substring(1);
	}

	public static String productStock(String stock) {
		if (!stock.contains("]")) {
			throw new IllegalArgumentException("상품의 입력 폼이 올바르지 않습니다.");
		}
		return stock.substring(0,stock.length()-1);
	}
}
