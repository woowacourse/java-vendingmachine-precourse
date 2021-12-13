package vendingmachine;

public class Beverage {
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

	private void checkCanSell(Money insertedMoney) {
		checkSoldOut();
		checkPrice(insertedMoney);
	}

	private void checkPrice(Money insertedMoney) {
		if (isMoneyShort(insertedMoney)) {
			throw new IllegalArgumentException("[ERROR] 돈이 부족합니다.");
		}
	}

	private boolean isMoneyShort(Money insertedMoney) {
		return !insertedMoney.isValuableThan(price);
	}

	private void checkSoldOut() {
		if (soldOut()) {
			throw new IllegalArgumentException("[ERROR] 모두 판매된 상품입니다.");
		}
	}

	public boolean soldOut() {
		return count == 0;
	}

	private void decreaseCount() {
		count--;
	}

	public boolean nameEquals(String name) {
		return this.name.equals(name);
	}
}
