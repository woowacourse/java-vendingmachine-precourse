package vendingmachine.io.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.data.VendingMachineData;
import vendingmachine.exception.IntegerTooSmallException;
import vendingmachine.exception.NameDuplicatedException;
import vendingmachine.exception.ProductInformationFormMismatchException;
import vendingmachine.exception.ProductPriceUnitException;
import vendingmachine.exception.ValueNotIntegerException;
import vendingmachine.type.Product;

public class InputValidator {

	public static void validMoneyValue(String money) {
		try {
			if (Integer.parseInt(money) <= 0) {
				throw new IntegerTooSmallException(VendingMachineData.INPUT_VALUE_TOO_SMALL_ERROR);
			}
		} catch (NumberFormatException nfe) {
			throw new ValueNotIntegerException(VendingMachineData.INPUT_VALUE_NOT_INTEGER_ERROR, nfe);
		}
	}

	public static void validProductInformationForm(String[] productArray) {
		Pattern productPattern = Pattern.compile(VendingMachineData.PRODUCT_REGEX);
		for (String product : productArray) {
			Matcher matcher = productPattern.matcher(product);
			checkForm(matcher);
			checkPrice(matcher);
			checkQuantity(matcher);
		}
	}

	public static void validNameNotDuplicate(List<Product> productList) {
		long distinctNameCount = productList.stream().map(Product::getName).distinct().count();
		if(distinctNameCount != productList.size()) {
			throw new NameDuplicatedException(VendingMachineData.PRODUCT_NAME_DUPLICATED_ERROR);
		}
	}

	private static void checkForm(Matcher matcher) {
		if (!matcher.find()) {
			throw new ProductInformationFormMismatchException(VendingMachineData.PRODUCT_INFO_FORM_NOT_MATCH_ERROR);
		}
	}

	private static void checkPrice(Matcher matcher) {
		int price = Integer.parseInt(matcher.group(2));
		if(price <= VendingMachineData.PRODUCT_MINIMUM_PRICE) {
			throw new IntegerTooSmallException(VendingMachineData.INPUT_VALUE_TOO_SMALL_ERROR);
		}
		if(price % VendingMachineData.PRODUCT_MINIMUM_UNIT != 0) {
			throw new ProductPriceUnitException(VendingMachineData.PRODUCT_PRICE_UNIT_ERROR);
		}
	}

	private static void checkQuantity(Matcher matcher) {
		int price = Integer.parseInt(matcher.group(2));
		if(price <= 0) {
			throw new IntegerTooSmallException(VendingMachineData.PRODUCT_QUANTITY_TOO_SMALL);
		}
	}
}
