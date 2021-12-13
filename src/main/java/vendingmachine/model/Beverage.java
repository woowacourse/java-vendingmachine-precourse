package vendingmachine.model;

import java.util.Objects;

public class Beverage implements Comparable<Beverage> {
	private static final int SOLD_OUT_COUNT = 0;
	private static final String SOLD_OUT_ERROR = "[ERROR] 모두 판매된 상품입니다.";
	private static final String MONEY_SHORT_ERROR = "[ERROR] 돈이 부족합니다.";

	private final String name;
	private final Money price;
	private int count;

	public Beverage(String name, Money price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void sell(Money insertedMoney) {
		checkCanSell(insertedMoney);
		insertedMoney.use(price);
		decreaseCount();
	}

	public boolean priceCheaperThan(Money insertedMoney) {
		return insertedMoney.isValuableThan(price);
	}

	private void checkCanSell(Money insertedMoney) {
		checkSoldOut();
		checkPrice(insertedMoney);
	}

	private void checkPrice(Money insertedMoney) {
		if (priceExpensiveThan(insertedMoney)) {
			throw new IllegalArgumentException(MONEY_SHORT_ERROR);
		}
	}

	private boolean priceExpensiveThan(Money insertedMoney) {
		return !priceCheaperThan(insertedMoney);
	}

	private void checkSoldOut() {
		if (soldOut()) {
			throw new IllegalArgumentException(SOLD_OUT_ERROR);
		}
	}

	public boolean soldOut() {
		return count == SOLD_OUT_COUNT;
	}

	private void decreaseCount() {
		count--;
	}

	public boolean nameEquals(String name) {
		return this.name.equals(name);
	}

	@Override
	public int compareTo(Beverage o) {
		return price.compareTo(o.price);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Beverage beverage = (Beverage)o;
		return name.equals(beverage.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
