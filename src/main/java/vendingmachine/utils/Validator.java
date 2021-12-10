package vendingmachine.utils;

import static vendingmachine.domain.product.Products.*;
import static vendingmachine.utils.Constant.*;

import java.util.regex.Matcher;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;
import vendingmachine.exception.AmountIsNotRangedException;
import vendingmachine.exception.AmountNumberFormatException;
import vendingmachine.exception.ProductInputFormatException;
import vendingmachine.exception.ProductInputSemicolonException;
import vendingmachine.exception.ProductIsNotExistedException;

public enum Validator {
	VALIDATOR(PRODUCTS);

	private boolean flag;
	private Products products;

	Validator(Products products){
		this.products = products;
	}

	public boolean validateNumberFormat(String amount) {
		flag = true;
		try {
			isNumberFormat(amount);
			isNumberIsRanged(Integer.parseInt(amount));
		} catch (IllegalArgumentException e) {
			flag = false;
		}
		return flag;
	}

	private void isNumberFormat(String amount) {
		if (!NUMBER_FORMAT.matcher(amount).matches()) {
			throw new AmountNumberFormatException();
		}
	}

	private void isNumberIsRanged(int amount) {
		if (amount % COIN_MIN != 0) {
			throw new AmountIsNotRangedException();
		}
	}

	public boolean validateProductInputFormat(String input){
		flag = true;
		Matcher matcher = PRODUCT_INPUT_FRAME_FORMAT.matcher(input);

		try {
			validateSemicolonFormat(input);
			isProductInputFormat(matcher);
		} catch (IllegalArgumentException e) {
			flag = false;
		}
		return flag;
	}

	private void isProductInputFormat(Matcher matcher) {
		isBoundedSquareBrackets(matcher);

		int index = 0;
		while(matcher.find(index++)){
			if(!matcher.group(1).matches(PRODUCT_INPUT_FORMAT)){
				throw new ProductInputFormatException();
			}
		}
	}

	private void isBoundedSquareBrackets(Matcher matcher){
		if(!matcher.find()) {
			throw new ProductInputFormatException();
		}
	}

	private void validateSemicolonFormat(String input){
		Matcher matcher = PRODUCT_INPUT_SEMICOLON_FRAME_FORMAT.matcher(input);
		isSemicolonFormat(matcher);
	}

	private void isSemicolonFormat(Matcher matcher) {
		while(matcher.find()){
			if(!matcher.group(1).matches(PRODUCT_INPUT_SEMICOLON_FORMAT)){
				throw new ProductInputSemicolonException();
			}
		}
	}

	public Product validateProductExisted(String productName){
		try{
			return isProductExisted(productName);
		}catch (IllegalArgumentException e){
			return null;
		}
	}

	private Product isProductExisted(String productName) {
		return products.getProductList().stream().filter(p -> p.getName().equalsIgnoreCase(productName)).findFirst()
			.orElseThrow(ProductIsNotExistedException::new);
	}
}
