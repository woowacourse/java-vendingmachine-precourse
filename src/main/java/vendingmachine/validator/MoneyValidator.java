package vendingmachine.validator;

import static vendingmachine.constant.ExceptionMessage.*;

import vendingmachine.constant.ExceptionMessage;

public class MoneyValidator {

	public static void validateInteger(String s) throws IllegalArgumentException{
		if(!s.matches("^[0-9]+$"))
			throw new IllegalArgumentException(MONEY_NOT_INTEGER.getMessage());
	}
}
