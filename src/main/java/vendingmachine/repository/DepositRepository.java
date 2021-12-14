package vendingmachine.repository;

import vendingmachine.domain.Money;
import vendingmachine.domain.Price;

public class DepositRepository {

	private static Money depositMoney;

	public DepositRepository() {
		depositMoney = Money.ZERO;
	}

	public DepositRepository(Money money) {
		depositMoney = money;
	}

	public Money save(Money money) {
		depositMoney = money;
		return get();
	}

	public Money get() {
		return depositMoney;
	}

	public void decrease(Price price) {
		depositMoney = depositMoney.minus(price);
	}
}
