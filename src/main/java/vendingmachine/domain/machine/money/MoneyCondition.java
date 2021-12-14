package vendingmachine.domain.machine.money;

public enum MoneyCondition {

	MININUM(100), DIVISION(10);

	private final int number;

	MoneyCondition(int number) {
		this.number = number;
	}

	public static boolean isTooSmall(int number) {
		return (number < MININUM.number);
	}

	public static boolean isNotDivide(int number) {
		return (number % DIVISION.number != 0);
	}

}
