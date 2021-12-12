package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Products {
	private static final String SEPARATOR = ";";
	private static final String REGEX = "\\[(.*),([0-9]*),([0-9]*)]";
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	private static final int NAME_INDEX = 1;
	private static final int PRICE_INDEX = 2;
	private static final int QUANTITY_INDEX = 3;

	private List<Product> products = new ArrayList<>();

	public Products(String input) {
		for (String individualInput : input.split(SEPARATOR)) {
			Matcher matcher = PATTERN.matcher(individualInput);
			if (matcher.find()) {
				Name name = new Name(matcher.group(NAME_INDEX));
				Money price = new Money(matcher.group(PRICE_INDEX));
				Quantity quantity = new Quantity(matcher.group(QUANTITY_INDEX));
				products.add(new Product(name, price, quantity));
			}
		}
	}

	public void save() {
		products.forEach(ProductRepository::save);
	}
}
