package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import vendingmachine.exception.NotFoundBeverageException;

public class Beverages {
	private final Map<Beverage, Integer> beverages;

	public Beverages() {
		beverages = new TreeMap<>();
	}

	public Map<Beverage, Integer> getBeverages() {
		return beverages;
	}

	public void add(Beverage beverage, int stock) {
		beverages.put(beverage, stock);
	}

	public Beverage findByName(String name) {
		for (Beverage beverage : beverages.keySet()) {
			if (beverage.isSameName(name)) {
				return beverage;
			}
		}
		throw new NotFoundBeverageException();
	}

}
