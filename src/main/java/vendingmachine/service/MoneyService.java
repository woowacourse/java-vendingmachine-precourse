package vendingmachine.service;

import vendingmachine.domain.Money;

public class MoneyService {
	public Money generateMoney(String input) {
		return new Money(Integer.parseInt(input));
	}
}
