package vendingmachine.domain;

import java.util.Objects;

public class Product {
	private static final String FORMAT = "[%s, %s, %s]";
	public static final String NAME = "상품";

	private Name name;
	private Price price;
	private Quantity quantity;

	public Product(Name name, Price price, Quantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public boolean matchName(Name other) {
		return this.name.equals(other);
	}

	public Price purchase() {
		quantity = quantity.minus(Quantity.ONE);
		return price;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Product product = (Product)other;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.format(FORMAT, name.toString(), price.toString(), quantity.toString());
	}

	public boolean isPurchasable(Money money) {
		return isQuantityEnough() && isMoneyEnough(money);
	}

	private boolean isMoneyEnough(Money money) {
		return !money.isLessThan(price);
	}

	public boolean isQuantityEnough() {
		return quantity.isEnough();
	}
}
