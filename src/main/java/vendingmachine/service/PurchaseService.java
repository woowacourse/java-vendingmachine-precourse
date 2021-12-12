package vendingmachine.service;

import vendingmachine.domain.Product;
import vendingmachine.util.Constants;
import vendingmachine.util.ExceptionHandler;
import vendingmachine.validator.InputValidator;

public class PurchaseService {
	private final ProductService productService;
	private int userInputAmount;
	private Product productToBuy;

	public PurchaseService(ProductService productService) {
		this.productService = productService;
	}

	public int getUserInputAmount() {
		return userInputAmount;
	}

	public String userInputAmountToString() {
		return userInputAmount + "원";
	}

	public void buy() {
		productService.delete(productToBuy);
		userInputAmount -= productToBuy.getPrice();
	}

	public void inputUserInputAmount(String inputAmount) {
		userInputAmount = Integer.parseInt(inputAmount);
	}

	public boolean validateInputAmount(String inputAmount) {
		boolean isValid = InputValidator.isNotEmpty(inputAmount)
			&& InputValidator.isDigit(inputAmount)
			&& InputValidator.isGreaterThan(Constants.INPUT_AMOUNT_MIN_VALUE, inputAmount);
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_USER_INPUT_AMOUNT);
		return isValid;
	}

	public boolean validateProductToBuy(String productNameToBuy) {
		boolean isValid = productService.findByName(productNameToBuy);
		if (isValid) {
			productToBuy = productService.getByName(productNameToBuy);
			isValid = productToBuy.priceIsSmallerThan(userInputAmount);
		}
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_PRODUCT_TO_BUY);
		return isValid;
	}

	public boolean shouldReturnChange() {
		return productService.isEmpty() || productService.isSmallerThanMinimumPrice(userInputAmount);
	}
}
