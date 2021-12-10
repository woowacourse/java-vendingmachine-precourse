package vendingmachine.model;

import static vendingmachine.validator.ProductValidator.*;

public class Product {

	private String name;
	private int price;
	private int quantity;

	public void init(String rawProduct) {
		String[] arguments = createProductArguments(rawProduct);

		this.name = arguments[0];
		this.price = Integer.parseInt(arguments[1]);
		this.quantity = Integer.parseInt(arguments[2]);
	}

	private String[] createProductArguments(String productRawInput) {
		String bracketRemovedInput = productRawInput.replace(OPENING_BRACKET, "")
			.replace(CLOSING_BRACKET, "");

		return bracketRemovedInput.split(ARGUMENT_CRITERIA, -1);
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void subtractQuantity() {
		this.quantity--;
	}

	public boolean isEmpty() {
		return this.quantity == 0;
	}

}
