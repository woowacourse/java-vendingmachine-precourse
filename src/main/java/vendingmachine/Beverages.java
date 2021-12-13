package vendingmachine;

import java.util.List;

public class Beverages {
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
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 없는 상품입니다."));
	}

	public boolean soldOut() {
		return beverages.stream()
			.allMatch(Beverage::soldOut);
	}
}
