package vendingmachine.model;

import java.util.Objects;

import org.assertj.core.util.Strings;

public class Beverage implements Comparable<Beverage> {
	private static final int SOLD_OUT_COUNT = 0;
	private static final String SOLD_OUT_ERROR = "[ERROR] 모두 판매된 상품입니다.";
	private static final String MONEY_SHORT_ERROR = "[ERROR] 돈이 부족합니다.";
	private static final String NAME_EMPTY_ERROR = "[ERROR] 상품 이름이 비어있습니다.";
	private static final Money PRICE_LOWER_BOUND = Money.from(100);
	private static final String PRICE_LOWER_ERROR = "[ERROR] 상품 가격이 너무 작습니다.";
	private static final String COUNT_TOO_SMALL = "[ERROR] 상품 개수가 너무 적습니다.";

	private final String name;
	private final Money price;
	private int count;

	public Beverage(String name, Money price, int count) {
		checkValidation(name, price, count);
		this.name = name;
		this.price = price;
		this.count = count;
	}

	private void checkValidation(String name, Money price, int count) {
		checkNameNotEmpty(name);
		checkPriceLowerBound(price);
		validateCount(count);
	}

	private void validateCount(int count) {
		if (count < SOLD_OUT_COUNT) {
			throw new IllegalArgumentException(COUNT_TOO_SMALL);
		}
	}

	private void checkPriceLowerBound(Money price) {
		if (!price.isValuableThan(PRICE_LOWER_BOUND)) {
			throw new IllegalArgumentException(PRICE_LOWER_ERROR);
		}
	}

	private void checkNameNotEmpty(String name) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException(NAME_EMPTY_ERROR);
		}
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
