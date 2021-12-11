package vendingmachine.validation;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.exception.ErrorMessage;

public class Validation {

	// 금액이 자연수인지 확인
	public static void validateCostIsNaturalNumber(String cost) {
		validateCharIsInt(ErrorMessage.COST_IS_NOT_NUMBER_ERROR,cost);

		if (Integer.parseInt(cost) <= 0) {
			throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_NUMBER_ERROR.getErrorMessage());
		}
	}

	// 입력 값이 빈 값인지 확인
	public static void validateNull(String cost){
		if(cost.replaceAll(" ","").length()==0){
			throw new IllegalArgumentException(ErrorMessage.INPUT_IS_BLANK_ERROR.getErrorMessage());
		}
	}

	// 금액이 10으로 나누어 떨어지지 않는 경우
	public static void validateDivideTen(int cost){
		if(cost%10!=0){
			throw new IllegalArgumentException(ErrorMessage.COST_IS_NOT_DIVIDE_TEN_ERROR.getErrorMessage());
		}
	}

	// 상품이 형식에 맞게 들어오지 않는 경우
	public static void validateProductFormat(String inputStr){
		for(String product: inputStr.split(";")) {
			if(!product.contains("[") || !product.contains("]")) {
				throw  new IllegalArgumentException(ErrorMessage.PRODUCT_INPUT_FORMAT_ERROR.getErrorMessage());
			}
		}
	}

	// 상품의 길이가 3(상품명, 가격, 수량)이 아닌 경우
	public static void validateProductLength(String[] product) {
		if(product.length!=3){
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_INPUT_LENGTH_ERROR.getErrorMessage());
		}
	}

	// 상품 가격이 100 이상 자연수가 아닐 경우
	public static void validateProductPrice(String price) {
		validateCharIsInt(ErrorMessage.PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR,price);

		if(Integer.parseInt(price) < 100) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_PRICE_IS_NOT_MORE_THAN_100_ERROR.getErrorMessage());
		}
	}

	// 상품 수량이 자연수가 아닐 경우
	public static void validateProductAmount(String amount) {
		validateCharIsInt(ErrorMessage.PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR,amount);

		if(Integer.parseInt(amount) == 0) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_AMOUNT_IS_NOT_NATURAL_NUMBER_ERROR.getErrorMessage());
		}
	}


	// 상품이 중복되어 들어오는 경우
	public static void validateProductIsDistinct(Product product, List<Product> products) {
		if(products.contains(product)) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_IS_DISTINCT_ERROR.getErrorMessage());
		}
	}

	// 구매할 상품명이 목록에 없을 경우
	public static void validateProductIsNotInProducts(String name, List<Product> products) {
		if(!products.contains(new Product(name,0,0))) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_IS_DISTINCT_ERROR.getErrorMessage());
		}
	}

	private static void validateCharIsInt(ErrorMessage errorMessage, String str) {
		for(char c: str.toCharArray()){
			if(!Character.isDigit(c)) {
				throw new IllegalArgumentException(errorMessage.getErrorMessage());
			}
		}
	}

}
