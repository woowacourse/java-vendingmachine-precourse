package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;

import vendingmachine.util.Constants;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;

public class InputController {
	public String inputVendingMachinePrice() {
		String vendingMachinePrice;
		do {
			vendingMachinePrice = InputView.inputVendingMachinePrice();
		} while (!validateVendingMachinePrice(vendingMachinePrice));
		return vendingMachinePrice;
	}

	public void inputProduct() {
		String products;
		do {
			products = InputView.inputProduct();
		} while (!validateProduct(products));
	}

	private void handleInputError(boolean isValid, String errorMessage) {
		try {
			if (!isValid) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(errorMessage);
		}
	}

	private boolean validateVendingMachinePrice(String vendingMachinePrice) {
		boolean isValid = InputValidator.isNotEmpty(vendingMachinePrice)
			&& InputValidator.isDigit(vendingMachinePrice)
			&& InputValidator.isGreaterThan(Constants.VENDING_MACHINE_PRICE_MIN_VALUE, vendingMachinePrice)
			&& InputValidator.isDivided(Constants.VENDING_MACHINE_PRICE_DENOMINATOR, vendingMachinePrice);
		handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_VENDING_MACHINE_PRICE);
		return isValid;
	}

	private boolean validateProduct(String products) {
		List<String> productArray = Arrays.asList(products.split(Constants.PRODUCT_SEPARATOR));
		boolean isValid = InputValidator.isNotEmpty(productArray)
			&& productArray.stream()
			.allMatch(product -> InputValidator.isNotEmpty(product)
				&& InputValidator.isWrappedWithSquareBrackets(product)
				&& validateProductInfo(product));
		handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_PRODUCT);
		return isValid;
	}

	private boolean validateProductInfo(String productInfo) {
		productInfo = productInfo.substring(1, productInfo.length() - 1);
		List<String> productInfos = Arrays.asList(productInfo.split(Constants.PRODUCT_INFO_SEPARATOR));
		return InputValidator.isNotEmpty(productInfos)
			&& productInfos.size() == Constants.PRODUCT_INFOS_SIZE
			&& productInfos.stream().allMatch(InputValidator::isNotEmpty)
			&& validateProductPrice(productInfos.get(1))
			&& validateProductCount(productInfos.get(2));
	}

	private boolean validateProductPrice(String price) {
		return InputValidator.isDigit(price)
			&& InputValidator.isGreaterThan(Constants.PRODUCT_PRICE_MIN_VALUE, price)
			&& InputValidator.isDivided(Constants.PRODUCT_PRICE_DENOMINATOR, price);
	}

	private boolean validateProductCount(String count) {
		return InputValidator.isDigit(count)
			&& InputValidator.isGreaterThan(Constants.PRODUCT_COUNT_MIN_VALUE, count);
	}
}
