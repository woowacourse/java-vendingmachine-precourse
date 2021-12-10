package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.exception.NotFoundBeverageException;

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

	public Beverage findByName(String name) {
		return beverages.stream()
			.filter(beverage -> beverage.getName().equals(name))
			.findAny()
			.orElseThrow(NotFoundBeverageException::new);
	}

}
