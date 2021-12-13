package vendingmachine.Model;

import java.util.ArrayList;

import vendingmachine.Utils.Constants;
import vendingmachine.Utils.Converter;
import vendingmachine.Utils.Validator.BeverageGroupValidator;

public class BeverageGroup {
	private static final int NO_PRICE = 0;
	private final ArrayList<Beverage> beverages;

	public BeverageGroup(String input) {
		validate(input);
		beverages = Converter.getBeverages(input);
	}

	private void validate(String input) {
		new BeverageGroupValidator(input);
	}

	public Beverage find(String nameString) {
		return beverages.stream()
			.filter(beverage -> beverage.name.equals(nameString))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Constants.ERROR_NAME_IN_NAMES));
	}

	public int findPrice(String nameString) {
		return find(nameString).price;
	}

	public void minusOneStock(String nameString) {
		find(nameString).minusOneStock();
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
