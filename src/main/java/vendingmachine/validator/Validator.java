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

	public static void validateProductsInputFormat(List<String> productsInfo) {
		for (String productInfo : productsInfo) {
			ProductValidator.validateFormat(productInfo);
		}
	}

	public static void validateEachProduct(List<List<String>> productsEachInfoList) {
		for (List<String> productInfo : productsEachInfoList) {
			Validator.ValidateProduct(productInfo);
		}
	}

	private static void ValidateProduct(List<String> productInfo) {
		ProductValidator.validateInfoMiss(productInfo);
		validateProductName(productInfo.get(0));
		validateProductPrice(productInfo.get(1));
		validateProductAmount(productInfo.get(2));
	}

	private static void validateProductName(String name) {
		ProductValidator.IsEmpty(name);
	}

	private static void validateProductPrice(String price) {
		NumberValidator.isInteger(price);
		int intPrice = Integer.parseInt(price);
		NumberValidator.isGreaterThanLowLimitOfPrice(intPrice);
		NumberValidator.isDivisibleByLowLimitOfCoin(intPrice);
	}

	private static void validateProductAmount(String amount) {
		NumberValidator.isInteger(amount);
		int intAmount = Integer.parseInt(amount);
		NumberValidator.isGreaterThanOrEqualToZero(intAmount);
	}
}
