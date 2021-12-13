package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class Beverages {
	private final Map<Beverage, Integer> beverages;

	public Beverages() {
		beverages = new HashMap<>();
	}

	public Map<Beverage, Integer> getBeverages() {
		return beverages;
	}

	public void add(Beverage beverage, int stock) {
		beverages.put(beverage, stock);
	}

	public int size() {
		return beverages.size();
	}

	public void sell(Beverage beverage) {
		beverages.put(beverage, beverages.get(beverage) - 1);
	}
}
