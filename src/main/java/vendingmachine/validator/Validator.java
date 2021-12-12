package vendingmachine.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static boolean isValidProductsInfo(String productsInfo) {
		try {
			checkProductsInfo(productsInfo);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void checkProductsInfo(String productsInfo) {
		for (String productInfo : Arrays.stream(productsInfo.split(";"))
			.map(String::trim)
			.collect(Collectors.toList())) {
			ProductValidator.checkFormat(productInfo);
			checkEachInfo(productInfo);
		}
	}

	private static void checkEachInfo(String productInfo) {
		List<String> info = Arrays.stream(productInfo.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
		ProductValidator.checkInfoMiss(info);
		checkProductName(info.get(0));
		checkProductPrice(info.get(1));
	}

	private static void checkProductName(String name){
		ProductValidator.checkIsEmptyName(name);
	}

	private static void checkProductPrice(String price) {
		NumberValidator.isInteger(price);
		int intPrice = Integer.parseInt(price);
		NumberValidator.checkLowLimitOfPrice(intPrice);
		NumberValidator.isDivisibleByLowLimitOfCoin(intPrice);
	}
}
