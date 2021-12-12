package vendingmachine.dto;

import vendingmachine.domain.Money;

public class RequestHoldingMoneyDto {
	private Money money;

	public RequestHoldingMoneyDto(Money money) {
		this.money = money;
	}

	public Money getMoney() {
		return money;
	}
}
