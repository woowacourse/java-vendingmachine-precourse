package vendingmachine.Model;

import java.util.ArrayList;

public class BeverageGroup {
	private static final int NO_PRICE = 0;

	private final ArrayList<Beverage> beverages = new ArrayList<>();

	public void add(Beverage beverage) {
		beverages.add(beverage);
	}

	public Beverage getBeverage(String nameString) {
		return beverages.stream()
			.filter(beverage -> beverage.name.equals(nameString))
			.findFirst()
			.orElse(null);
	}

	public int getMinPrice() {
		return beverages.stream()
			.mapToInt(beverage -> beverage.price)
			.min()
			.orElse(NO_PRICE);
	}

	public String[] getNames() {
		return beverages.stream()
			.map(beverage -> beverage.name)
			.toArray(String[]::new);
	}

	public boolean isAllSoldOut() {
		return beverages.stream()
			.allMatch(Beverage::isSoldOut);
	}
}
