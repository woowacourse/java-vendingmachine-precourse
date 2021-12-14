package vendingmachine.domain;

import java.util.Objects;

public class Product implements Comparable<Product> {
	private final Name name;
	private final Amount amount;
	private final Count count;

	public Product(String name, String amount, String count) {
		this.name = Name.of(name);
		this.amount = Amount.of(amount);
		this.count = Count.of(count);
	}

	public static Product of(String name, String amount, String count) {
		return new Product(name, amount, count);
	}

	public int toAmount() {
		return this.amount.toInt();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public int compareTo(Product o) {
		return Integer.compare(this.amount.toInt(), o.amount.toInt());
	}

	public int toCount() {
		return this.count.toInt();
	}

	@Override
	public String toString() {
		return this.name.toString();
	}

	public Name toName() {
		return this.name;
	}
}
