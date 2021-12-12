package vendingmachine.dto;

import vendingmachine.domain.Money;

public class ResponseMoneyDto {
	private Money money;

	public ResponseMoneyDto(Money money) {
		this.money = money;
	}

	public Money getMoney() {
		return money;
	}
}
