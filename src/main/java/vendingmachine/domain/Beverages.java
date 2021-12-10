package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Beverages {
	private final List<Beverage> beverages;

	public Beverages() {
		beverages = new ArrayList<>();
	}

	public List<Beverage> getBeverages() {
		return beverages;
	}

	public void add(Beverage beverage) {
		beverages.add(beverage);
	}
}
