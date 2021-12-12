package vendingmachine.validator;

import static vendingmachine.constant.ExceptionMessage.*;
import static vendingmachine.constant.Symbol.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductListValidator {

	private static final int PRICE_MINIMUM = 100;
	private static final int QUANTITY_MINIMUM = 0;

	private static final String SINGLE_PRODUCT_REGEX = "^\\[.+]$";
	private static final String MULTIPLE_PRODUCT_REGEX = "^\\[.+];\\[.+]$";
	private static final String COMMA_REGEX = "^\\[.+,.+,.+]$";
	private static final String NAME_LENGTH_AND_INTEGER_REGEX = "^\\[.+,\\d+,\\d+]$";

	public static void validateBracketAndSemiColon(String input) throws IllegalArgumentException {
		if (!input.matches(SINGLE_PRODUCT_REGEX) && !input.matches(MULTIPLE_PRODUCT_REGEX))
			throw new IllegalArgumentException(PRODUCT_FORMAT.getMessage());
	}

	public static void validateComma(String input) throws IllegalArgumentException {
		int commaCount = 0;
		Matcher matcher = Pattern.compile(PRODUCT_INFO_DELIMITER.getSymbol()).matcher(input);
		while (matcher.find())
			commaCount++;
		if (!Pattern.matches(COMMA_REGEX, input) || commaCount != 2)
			throw new IllegalArgumentException(PRODUCT_FORMAT_EACH.getMessage());
	}

	public static void validateNameLengthAndInteger(String input) throws IllegalArgumentException {
		if (!Pattern.matches(NAME_LENGTH_AND_INTEGER_REGEX, input))
			throw new IllegalArgumentException(PRODUCT_FORMAT_INFO_EACH.getMessage());
	}

	public static void validatePrice(int price) throws IllegalArgumentException {
		if (price < PRICE_MINIMUM || price % 10 != 0)
			throw new IllegalArgumentException(INVALID_PRICE.getMessage());
	}

	public static void validateQuantity(int quantity) throws IllegalArgumentException {
		if (quantity < QUANTITY_MINIMUM)
			throw new IllegalArgumentException(INVALID_QUANTITY.getMessage());
	}
}
