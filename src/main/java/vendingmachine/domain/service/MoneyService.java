package vendingmachine.domain.service;

import vendingmachine.domain.repository.MoneyRepository;

public class MoneyService {
	private final MoneyRepository money = new MoneyRepository();

	public void inputMoney(int money) {
		this.money.addAmount(money);
	}

	public void useMoney(int money) {
		this.money.deductAmount(money);
	}
}
