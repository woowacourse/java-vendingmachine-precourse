package vendingmachine.domain;

public class MoneyRepository {
	private static final String INIT_MONEY = "0";

	private static final Money money = new Money(INIT_MONEY);

	public static Money get() {
		return money;
	}

	public static void add(Money money) {
		MoneyRepository.money.add(money);
	}

	public static void sub(Money money) {
		MoneyRepository.money.sub(money);
	}

	public static void clear() {
		money.clear();
	}
}
