package vendingmachine.domain;

import java.util.Collections;
import java.util.Comparator;
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

	public int getMinimumBeveragePrice() {
		return Collections.min(beverages.keySet(), Comparator.comparingInt(Beverage::getPrice)).getPrice();
	}

	public boolean isAllSoldOut() {
		for (Integer stock : beverages.values()) {
			if (stock > 0) {
				return false;
			}
		}
		return true;
	}

	public void sell(Beverage beverage) {
		beverages.put(beverage, beverages.get(beverage) - 1);
	}
}
