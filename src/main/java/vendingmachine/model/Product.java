package vendingmachine.model;

import java.util.Arrays;
import java.util.List;

import vendingmachine.constant.Rule;

public class Product {

	private Name name;
	private Price price;
	private TheNumber theNumber;

	public Product() {
		name = new Name();
		price = new Price();
		theNumber = new TheNumber();
	}

	public void set(String input) {
		checkInput(input);
		input = input.substring(1, input.length() - 1);
		List<String> productInfo = Arrays.asList(input.split(Rule.DELIMETER_PRODUCT_INFO));
		name.set(productInfo.get(0));
		price.set(productInfo.get(1));
		theNumber.set(productInfo.get(2));
	}

	private void checkInput(String input) {

	}
}
