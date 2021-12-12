package vendingmachine.Model;

import java.util.ArrayList;

import vendingmachine.Utils.Constants;
import vendingmachine.Utils.Validator.BeverageGroupValidator;

public class BeverageGroup {
	private static final int NO_PRICE = 0;

	private final ArrayList<Beverage> beverages = new ArrayList<>();

	public BeverageGroup(String input) {
		validate(input);
		for (String[] values : Converter.getBeverages(input)) {
			beverages.add(new Beverage(values));
		}
	}

	private void validate(String input) {
		new BeverageGroupValidator(input);
	}

	public Beverage getBeverage(String nameString) {
		return beverages.stream()
			.filter(beverage -> beverage.name.equals(nameString))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Constants.ERROR_NAME_IN_NAMES));
	}

	public int getMinPrice() {
		return beverages.stream()
			.mapToInt(beverage -> beverage.price)
			.min()
			.orElse(NO_PRICE);
	}

	public boolean isAllSoldOut() {
		return beverages.stream()
			.allMatch(Beverage::isSoldOut);
	}
}
