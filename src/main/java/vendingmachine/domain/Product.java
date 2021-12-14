package vendingmachine.domain;

import java.util.Objects;

public class Product implements Comparable<Product> {
	private static final int MIN_PRICE = 100;
	private static final int MIN_AMOUNT = 0;

	private static final String NAME_ERROR_MESSAGE = "상품 이름을 잘못 입력했습니다.";
	private static final String PRICE_ERROR_MESSAGE = "상품 가격을 잘못 입력했습니다.";
	private static final String COUNT_ERROR_MESSAGE = "상품 수량을 잘못 입력했습니다.";

	private String name;
	private Money price;
	private int amount;

	public Product(String name, Money price, int amount) throws IllegalArgumentException {
		this.name = validateName(name);
		this.price = validatePrice(price);
		this.amount = validateAmount(amount);
	}

	public boolean soldOut() {
		return amount == MIN_AMOUNT;
	}

	public boolean isBuy(Money insertMoney) {
		return !soldOut() &&
			price.compareTo(insertMoney) <= 0;
	}

	public void buy() {
		if (soldOut()) {
			return;
		}
		amount -= 1;
	}

	public Money getPrice() {
		return price;
	}

	private String validateName(String name) throws IllegalArgumentException {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
		}
		return name;
	}

	private Money validatePrice(Money price) throws IllegalArgumentException {
		if (price.getAmount() < MIN_PRICE) {
			throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
		}
		return price;
	}

	private int validateAmount(int amount) throws IllegalArgumentException {
		if (amount < MIN_AMOUNT) {
			throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
		}
		return amount;
	}

	@Override
	public int compareTo(Product o) {
		return this.price.compareTo(o.price);
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
}
