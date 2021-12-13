package vendingmachine.domain;

import vendingmachine.validation.IntegerDividableException;
import vendingmachine.validation.IntegerGreaterValidation;
import vendingmachine.validation.Validator;

public class Price extends Money {
	private static final int MIN = 100;
	private static final int DIV = 10;
	public static final String NAME = "가격";

	public Price(int amount) {
		super(Validator.validate(NAME, amount, new IntegerDividableException(DIV), new IntegerGreaterValidation(MIN)));
	}
}
