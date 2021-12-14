package vendingmachine.utils.validator;

import static vendingmachine.utils.message.ErrorMessage.*;


import java.util.List;
import java.util.regex.Pattern;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public class MoneyValidator {
	private static final int EXPECTED_VALUE_WHEN_DIVIDING = 0;
	private static final int ZERO_NUMBER = 0;

	//투입금액
	public static boolean checkIsValidInsertMoney(String input) {
		try {
			isNotBlank(input);
			isDigit(input);
			isNotZeroNumber(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	//잔판기잔돈 총액
	public static boolean checkIsValidTotalAmount(String input) {
		try {
			isNotBlank(input);
			isDigit(input);
			isNotZeroNumber(input);
			isValidToDivideByTen(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static void isValidToDivideByTen(String input) {
		if (!(Integer.parseInt(input) % Coin.COIN_10.getAmount() == EXPECTED_VALUE_WHEN_DIVIDING)) {
			throw new IllegalArgumentException(ERROR_MONEY_NOT_DIVIDED_BY_TEN.getText());
		}
	}

	public static void isNotZeroNumber(String input) {
		if (Integer.parseInt(input) == ZERO_NUMBER) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_ZERO.getText());
		}
	}

	public static void isDigit(String input) {
		if (!Pattern.matches("^[0-9]+$", input)) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_NOT_NUMBER.getText());
		}
	}

	public static void isNotBlank(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ERROR_MONEY_IS_BLANK.getText());
		}
	}

	// 상품 재고와 최소 가격 조건
	public static boolean checkIsValidToBuyProduct(VendingMachine vendingMachine) {
		if (vendingMachine.isValidToBuyProductWithCurrentMoney()) {
			return vendingMachine.isValidProductStock();
		}
		return false;
	}
}
