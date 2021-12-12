package vendingmachine.dto;

import vendingmachine.domain.Money;

public class RequestInsertMoneyDto {
	private Money money;

	public RequestInsertMoneyDto(Money money) {
		this.money = money;
	}

	public Money getMoney() {
		return money;
	}
}
