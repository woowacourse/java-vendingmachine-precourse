package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputtedDataValidation {

	private static final String NUMBER_PATTERN = "^[0-9]*$";

	private String errorMessage;

	public InputtedDataValidation() {
		this.errorMessage = "";
	}

	public boolean validateNumberInput(final String inputtedData) {
		if(!Pattern.matches(NUMBER_PATTERN, inputtedData)) {
			errorMessage = VendingMachineMessage.notNumberError(inputtedData);
			throw new IllegalArgumentException(errorMessage);
		}
		if(inputtedData.length() <= 1) {
			errorMessage = VendingMachineMessage
				.invalidLengthError(inputtedData);
			throw new IllegalArgumentException(errorMessage);
		}
		if(inputtedData.charAt(inputtedData.length() - 1) != '0') {
			errorMessage = VendingMachineMessage
				.invalidNumberError(inputtedData);
			throw new IllegalArgumentException(errorMessage);
		}
		return true;
	}

	private boolean matchBracketPair(final String productsInformation) {
		int bracket = 0;
		for (char ch : productsInformation.toCharArray()) {
			if(ch == '[') {
				bracket++;
			}
			if(ch == ']') {
				bracket--;
			}
		}
		return bracket == 0;
	}

	private boolean distinguishProducts(final String productsInformation) {
		for(int index = 0; index < productsInformation.length(); index++) {
			final char ch = productsInformation.charAt(index);
			if(index < productsInformation.length() - 1
					&& ch == ']' && productsInformation.charAt(index + 1) != ';') {
				return false;
			}
			if (index >= 1 && ch == '['
					&& productsInformation.charAt(index - 1) != ';') {
				return false;
			}
		}
		return true;
	}

	public boolean haveEnoughProductInformation(final String productsInformation) {
		final List<String> productsList = Arrays
			.stream(productsInformation.split(";"))
			.collect(Collectors.toList());
		for(String product : productsList) {
			final List<String> productInformation = Arrays
				.stream(product.split(","))
				.collect(Collectors.toList());
			if(productInformation.size() != 3) {
				return false;
			}
		}
		return true;
	}

	public boolean validateProductsInformation(final String productsInformation) {
		if (!matchBracketPair(productsInformation)) {
			errorMessage = VendingMachineMessage.bracketsDontMatch(productsInformation);
			throw new IllegalArgumentException(errorMessage);
		}
		if (!distinguishProducts(productsInformation)) {
			errorMessage = VendingMachineMessage.distinguishProductsError(productsInformation);
			throw new IllegalArgumentException(errorMessage);
		}
		if (!haveEnoughProductInformation(productsInformation)) {
			errorMessage = VendingMachineMessage.productInformationIsntEnough(productsInformation);
			throw new IllegalArgumentException(errorMessage);
		}
		return true;
	}
}
