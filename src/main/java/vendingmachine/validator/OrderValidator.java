package vendingmachine.validator;

import static vendingmachine.Constants.*;

import vendingmachine.model.ProductModel;
import vendingmachine.view.ErrorView;

public class OrderValidator extends CommonValidator {
	public static boolean checkProductName(String inputLine) {
		try {
			exceptionStringEmptyOrSpace(inputLine);
			exceptionNameNotMatch(inputLine);
			exceptionHasZeroCount(inputLine);
			exceptionNotEnoughMoney(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.error(ERROR_PRODUCTS);
			return false;
		}
	}

	private static void exceptionNotEnoughMoney(String name) {
		if (!ProductModel.canBuyProductWithUserMoney(name)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionNameNotMatch(String inputLine) {
		if (!ProductModel.hasProductName(inputLine)) {
			throw new IllegalArgumentException();
		}
	}

	private static void exceptionHasZeroCount(String inputLine) {
		if (!ProductModel.hasMoreThanOneCount(inputLine)) {
			throw new IllegalArgumentException();
		}
	}
}
