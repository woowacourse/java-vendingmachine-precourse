package vendingmachine;

public class Money implements Comparable<Money> {
	private int amount;

	private Money(int amount) {
		checkValidation(amount);
		this.amount = amount;
	}

	private void checkValidation(int amount) {
		checkLowerLimit(amount);
		checkDivideBy10(amount);
	}

	private void checkLowerLimit(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
		}
	}

	private void checkDivideBy10(int amount) {
		if (amount % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 금액은 10으로 나누어 떨어져야 합니다.");
		}
	}

	public static Money from(int amount) {
		return new Money(amount);
	}

	public int getAmount() {
		return amount;
	}

	public boolean isValuableThan(Money other) {
		return amount >= other.amount;
	}

	public boolean isRemain() {
		return amount > 0;
	}

	public void use(Money other) {
		this.amount -= other.amount;
	}

	public Money totalAmountOfCount(int count) {
		return new Money(amount * count);
	}

	public int getMaxCountOfCoin(Money coinAmount) {
		return this.amount / coinAmount.amount;
	}

	@Override
	public int compareTo(Money o) {
		return amount - o.amount;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money = (Money)o;
		return amount == money.amount;
	}

	@Override
	public int hashCode() {
		return amount;
	}
}
