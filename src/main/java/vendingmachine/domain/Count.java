package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.utils.Util;

public class Count implements Comparable<Count> {
	private final int count;

	public Count(String count) {
		this.count = Util.convertStringToInt(count);
	}

	public static Count of(String count) {
		return new Count(count);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Count count1 = (Count)o;
		return count == count1.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}

	public int toInt() {
		return this.count;
	}

	@Override
	public int compareTo(Count o) {
		return Integer.compare(this.count, o.count);
	}
}
