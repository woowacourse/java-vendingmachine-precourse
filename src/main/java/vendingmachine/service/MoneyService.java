package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.validation.IntegerParsableValidation;
import vendingmachine.validation.Validator;

public class MoneyService {
	public Money generateMoney(String input) {
		String validated = Validator.validate(Money.NAME, input, new IntegerParsableValidation());
		return new Money(Integer.parseInt(validated));
	}
}
