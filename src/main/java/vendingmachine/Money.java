package vendingmachine;

public class Money {
	private int amount;

	private Money(int amount) {
		this.amount = amount;
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
		return amount > 10;
	}

	public void use(Money other) {
		this.amount -= other.amount;
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
