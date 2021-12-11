package vendingmachine.Model;

import java.util.ArrayList;

public class BeverageGroup {
	private final ArrayList<Beverage> beverages = new ArrayList<>();

	public void add(Beverage beverage) {
		beverages.add(beverage);
	}

	public Beverage getBeverages(String name) {
		return beverages.stream()
			.filter(beverage -> beverage.name.equals(name))
			.findAny()
			.orElse(null);
	}

	public int getMinPrice() {
		return beverages.stream()
			.map(beverage -> beverage.price)
			.max(Integer::compare)
			.orElse(0);
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
