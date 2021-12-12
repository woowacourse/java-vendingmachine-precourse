package vendingmachine.validator;

import java.util.List;

public class Validator {
	public static boolean isValidMoneyInMachine(String moneyInVendingMachine) {
		try {
			NumberValidator.isInteger(moneyInVendingMachine);
			int intMoneyInVendingMachine = Integer.parseInt(moneyInVendingMachine);
			NumberValidator.isGreaterThanOrEqualToZero(intMoneyInVendingMachine);
			NumberValidator.isDivisibleByLowLimitOfCoin(intMoneyInVendingMachine);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean isValidProductsInputFormat(List<String> productsInfo) {
		try {
			validateProductsInputFormat(productsInfo);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void validateProductsInputFormat(List<String> productsInfo) {
		for (String productInfo : productsInfo) {
			ProductValidator.checkFormat(productInfo);
		}
	}

	public static boolean isValidProduct(List<List<String>> productsEachInfoList) {
		try {
			for (List<String> productInfo : productsEachInfoList) {
				Validator.validateEachProduct(productInfo);
			}
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void validateEachProduct(List<String> productInfo) {
		ProductValidator.checkInfoMiss(productInfo);
		validateProductName(productInfo.get(0));
		validateProductPrice(productInfo.get(1));
		validateProductAmount(productInfo.get(2));
	}

	private static void validateProductName(String name) {
		ProductValidator.checkIsEmptyName(name);
	}

	private static void validateProductPrice(String price) {
		NumberValidator.isInteger(price);
		int intPrice = Integer.parseInt(price);
		NumberValidator.checkLowLimitOfPrice(intPrice);
		NumberValidator.isDivisibleByLowLimitOfCoin(intPrice);
	}

	private static void validateProductAmount(String amount) {
		NumberValidator.isInteger(amount);
		int intAmount = Integer.parseInt(amount);
		NumberValidator.isGreaterThanOrEqualToZero(intAmount);
	}
}
