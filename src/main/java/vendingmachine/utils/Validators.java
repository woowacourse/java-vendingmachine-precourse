package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public class Validators {

	public static void checkValidFormatOfMoney(String inputValue) {
		if (!(inputValue.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_INPUT_ONLY_DIGIT);
		}
	}

	public static void checkValidRangeMoney(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (!(Constant.CONSTANT_ONE <= number)) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_IS_OR_GREATER_THAN_ONE);
		}
	}

	public static void checkValidMoney(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (number % Constant.LOWEST_COIN_AMOUNT != Constant.CONSTANT_ZERO) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_TEN_UNIT);
		}
	}

	public static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_NO_SPACE);
		}
	}

	public static void checkValidFirstValue(String inputValue, String delimeter) {
		if (inputValue.charAt(Constant.CONSTANT_ZERO) == delimeter.charAt(Constant.CONSTANT_ZERO)) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_NO_PRODUCT_NAME);
		}
	}

	public static void checkPatternOfProduct(String inputValue, String delimeter, String regex) {
		Pattern pattern = Pattern.compile(regex);
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)
			.collect(Collectors.toList());
		checkPattern(pattern, splitedInputValue);
		checkAmount(pattern, splitedInputValue);
		checkCount(pattern, splitedInputValue);
		checkDuplicatesOfName(pattern, splitedInputValue);
	}

	private static void checkDuplicatesOfName(Pattern pattern, List<String> splitedInputValue) {
		List<String> names = splitedInputValue.stream()
			.map(stringValue -> {
				Matcher matcher = pattern.matcher(stringValue);
				if (matcher.find()) {
					String name = matcher.group(Constant.CONSTANT_ONE);
					return name;
				}
				return Constant.EMPTY_STRING;
			})
			.collect(Collectors.toList());
		boolean isDuplicatesOfName = names.stream()
			.distinct().count() != names.size();
		if (isDuplicatesOfName) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_DUPLICATE_NAME);
		}
	}

	private static void checkCount(Pattern pattern, List<String> splitedInputValue) {
		boolean isValidCount = splitedInputValue.stream()
			.mapToInt(stringValue -> {
				Matcher matcher = pattern.matcher(stringValue);
				if (matcher.find()) {
					String count = matcher.group(Constant.CONSTANT_THREE);
					return Integer.parseInt(count);
				}
				return Constant.CONSTANT_ZERO;
			})
			.allMatch(count -> count >= Constant.CONSTANT_ONE);
		if (!isValidCount) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_MORE_THAN_ONE);
		}
	}

	private static void checkAmount(Pattern pattern, List<String> splitedInputValue) {
		boolean isValidAmount = splitedInputValue.stream()
			.mapToInt(stringValue -> {
				Matcher matcher = pattern.matcher(stringValue);
				if (matcher.find()) {
					String amount = matcher.group(Constant.CONSTANT_TWO);
					return Integer.parseInt(amount);
				}
				return Constant.CONSTANT_ZERO;
			})
			.allMatch(amount -> amount >= Constant.CONSTANT_100
				&& amount % Constant.LOWEST_COIN_AMOUNT == Constant.CONSTANT_ZERO);
		if (!isValidAmount) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_INVALID_AMOUNT);
		}
	}

	private static void checkPattern(Pattern pattern, List<String> splitedInputValue) {
		boolean isMatched = splitedInputValue.stream()
			.allMatch(stringValue -> pattern.matcher(stringValue).find());

		if (!isMatched) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_INVALID_PATTERN);
		}
	}

	public static void checkValidProduct(String inputValue) {
		VendingMachine vendingMachine = VendingMachine.getInstance();
		Product product = vendingMachine.findProductByName(inputValue);
		if (!(vendingMachine.isProductAvailable(product))) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_THIS_IS_ZERO_COUNT);
		}
		if (!vendingMachine.isUserPurchasable(product)) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_INVALID_MONEY);
		}
	}

	public static void checkValidLengthOfProductName(String inputValue) {
		int inputValueLength = inputValue.length();
		if (!(1 <= inputValueLength)) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_INVALID_RANGE);
		}
	}

	public static void checkIncludeSpace(String inputValue) {
		if (inputValue.trim().contains(Constant.CONSTANT_SPACE)) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_NO_SPACE);
		}
	}
}
