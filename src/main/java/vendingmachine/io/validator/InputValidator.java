package vendingmachine.io.validator;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import vendingmachine.data.VendingMachineData;
import vendingmachine.exception.IntegerTooSmallException;
import vendingmachine.exception.NameDuplicatedException;
import vendingmachine.exception.ProductInformationFormMismatchException;
import vendingmachine.exception.ValueNotIntegerException;
import vendingmachine.type.Product;

public class InputValidator {

	public static void validMoneyValue(String money) {
		int tmp;
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
			if (!matcher.find()) {
				throw new ProductInformationFormMismatchException(VendingMachineData.PRODUCT_INFO_FORM_NOT_MATCH_ERROR);
			}
			if(Integer.parseInt(matcher.group(2)) <= 0) {
				throw new IntegerTooSmallException(VendingMachineData.INPUT_VALUE_TOO_SMALL_ERROR);
			}
			if(Integer.parseInt(matcher.group(3)) <= 0) {
				throw new IntegerTooSmallException(VendingMachineData.PRODUCT_QUANTITY_TOO_SMALL);
			}
		}
	}

	public static void validNameNotDuplicate(List<Product> productList) {
		long distinctNameCount = productList.stream().map(Product::getName).distinct().count();
		if(distinctNameCount != productList.size()) {
			throw new NameDuplicatedException(VendingMachineData.PRODUCT_NAME_DUPLICATED_ERROR);
		}
	}
}
