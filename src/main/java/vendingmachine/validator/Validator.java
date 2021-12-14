package vendingmachine.validator;

import java.util.List;

public class Validator {
	public static boolean isValidMoneyInMachine(int moneyInMachine) {
		try {
			NumberValidator.isGreaterThanOrEqualToZero(moneyInMachine);
			NumberValidator.isDivisibleByMinimumUnit(moneyInMachine);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void validateProductsInputFormat(List<String> productsInfo) {
		for (String productInfo : productsInfo) {
			ProductValidator.validateFormat(productInfo);
		}
	}

	public static void validateEachProduct(List<List<String>> productsEachInfoList) {
		for (List<String> productInfo : productsEachInfoList) {
			validateProduct(productInfo);
		}
	}

	private static void validateProduct(List<String> productInfo) {
		ProductValidator.validateInfoMiss(productInfo);
		validateProductName(productInfo.get(ProductIdx.NAME.ordinal()));
		validateProductPrice(productInfo.get(ProductIdx.PRICE.ordinal()));
		validateProductAmount(productInfo.get(ProductIdx.AMOUNT.ordinal()));
	}

	private static void validateProductName(String name) {
		ProductValidator.isEmpty(name);
	}

	private static void validateProductPrice(String price) {
		NumberValidator.isInteger(price);
		int intPrice = Integer.parseInt(price);
		NumberValidator.isGreaterThanOrEqualToLeastPrice(intPrice);
		NumberValidator.isDivisibleByMinimumUnit(intPrice);
	}

	private static void validateProductAmount(String amount) {
		NumberValidator.isInteger(amount);
		int intAmount = Integer.parseInt(amount);
		NumberValidator.isGreaterThanOrEqualToZero(intAmount);
	}

	public static boolean isValidInputMoney(int inputMoney) {
		try {
			NumberValidator.isDivisibleByMinimumUnit(inputMoney);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private enum ProductIdx {NAME, PRICE, AMOUNT}
}
