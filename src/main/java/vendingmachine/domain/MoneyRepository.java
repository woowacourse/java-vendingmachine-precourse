package vendingmachine.domain;

public class MoneyRepository {
	private static final String INIT_MONEY = "0";

	private static final Money money = new Money(INIT_MONEY);

	public static void add(Money money) {
		MoneyRepository.money.add(money);
	}

	public static Money get() {
		return money;
	}
}
