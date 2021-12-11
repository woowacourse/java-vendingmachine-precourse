package vendingmachine.utils.validator;

import static vendingmachine.utils.ErrorType.*;


import java.util.regex.Pattern;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class InputMoneyValidator {
	private static final int EXPECTED_VALUE_WHEN_DIVIDING = 0;
	private static final int ZERO_NUMBER = 0;

	public static boolean checkIsValidInputMoney(String inputMoney) {
		try {
			isNotBlank(inputMoney);
			isDigit(inputMoney);
			isNotZeroNumber(inputMoney);
			isValidToDivideByTen(inputMoney);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean isValidToDivideByTen(String input) {
		if (!(Integer.parseInt(input) % Coin.COIN_10.getAmount() == EXPECTED_VALUE_WHEN_DIVIDING)) {
			throw new IllegalArgumentException(ERROR_MONEY_NOT_DIVIDED_BY_TEN.getText());
		}
		return true;
	}

	public static boolean isNotZeroNumber(String input) {
		if (Integer.parseInt(input) == ZERO_NUMBER) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_ZERO.getText());
		}
		return true;
	}

	public static boolean isDigit(String input) {
		if (!Pattern.matches("^[0-9]+$", input)) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_NOT_NUMBER.getText());
		}
		return true;
	}

	public static boolean isNotBlank(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_BLANK.getText());
		}
		return true;
	}

	public static boolean isValidToBuyProduct(VendingMachine vendingMachine) {
		int currentInputMoney = vendingMachine.getInputMoney().getCurrentMoney();
		int minPriceProduct = vendingMachine.getProducts().getMinPriceProduct();
		return currentInputMoney >= minPriceProduct;
	}
}
