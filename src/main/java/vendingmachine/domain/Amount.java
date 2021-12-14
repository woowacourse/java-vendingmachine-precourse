package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.utils.Util;

public class Amount implements Comparable<Amount> {
	private int amount;

	public Amount(String amount) {
		this.amount = Util.convertStringToInt(amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Amount amount1 = (Amount)o;
		return amount == amount1.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	public static Amount of(String amount) {
		return new Amount(amount);
	}

	public int toInt() {
		return this.amount;
	}

	@Override
	public int compareTo(Amount o) {
		return Integer.compare(this.amount, o.amount);
	}
}
