package vendingmachine.domain;

import vendingmachine.validation.IntegerParsableValidation;
import vendingmachine.validation.Validator;

public class ProductCandidate {

	private static final String FORMAT = "[%s, %s, %s]";

	private String name;
	private String price;
	private String quantity;

	public ProductCandidate(String name, String price, String quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product toProduct() {
		return new Product(
			new Name(name),
			new Price(toPrice()),
			new Quantity(toQuantity())
		);
	}

	private int toQuantity() {
		String validated = Validator.validate(Quantity.NAME, quantity, new IntegerParsableValidation());
		return Integer.parseInt(validated);
	}

	private int toPrice() {
		String validated = Validator.validate(Price.NAME, price, new IntegerParsableValidation());
		return Integer.parseInt(validated);
	}

	@Override
	public String toString() {
		return String.format(FORMAT, name, price, quantity);
	}
}
