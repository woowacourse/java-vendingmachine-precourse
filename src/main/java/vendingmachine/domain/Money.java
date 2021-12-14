package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.utils.Util;

public class Money implements Comparable<Money> {
	private int money;

	public Money(String money) {
		this.money = Util.convertStringToInt(money);
	}

	public static Money of(String money) {
		return new Money(money);
	}

	public void increaseWith(int value) {
		this.money += value;
	}

	public int toInt() {
		return this.money;
	}

	@Override
	public int compareTo(Money o) {
		return Integer.compare(this.money, o.money);
	}

	public void decreaseWith(int pickRangdomCoin) {
		this.money -= pickRangdomCoin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}

	public boolean isOrGreaterThan(Product product) {
		return this.money >= product.toAmount();
	}
}
