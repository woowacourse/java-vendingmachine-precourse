package vendingmachine.model;

import java.util.List;

public class Beverages {
	private static final String NO_EXIST_BEVERAGE_ERROR = "[ERROR] 없는 상품입니다.";

	private final List<Beverage> beverages;

	public Beverages(List<Beverage> beverages) {
		this.beverages = beverages;
	}

	public void sell(String beverageName, Money insertedMoney) {
		Beverage beverage = findByName(beverageName);
		beverage.sell(insertedMoney);
	}

	private Beverage findByName(String beverageName) {
		return beverages.stream()
			.filter(beverage -> beverage.nameEquals(beverageName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(NO_EXIST_BEVERAGE_ERROR));
	}

	public boolean canSellMore(Money balance) {
		return isBeverageRemain() && canBuyAnyBeverage(balance);
	}

	private boolean isBeverageRemain() {
		return beverages.stream()
			.anyMatch(beverage -> !beverage.soldOut());
	}

	private boolean canBuyAnyBeverage(Money balance) {
		Beverage beverage = getMinimumPriceBeverage();
		return beverage.priceCheaperThan(balance);
	}

	private Beverage getMinimumPriceBeverage() {
		return beverages.stream()
			.min(Beverage::compareTo)
			.get();
	}
}
