package vendingmachine.model;

import java.util.Arrays;
import java.util.List;

import vendingmachine.constant.Rule;
import vendingmachine.util.SplitChecker;
import vendingmachine.util.StringChecker;

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
		String inputWithoutBracket = input.substring(1, input.length() - 1);
		List<String> productInfo = Arrays.asList(inputWithoutBracket.split(Rule.DELIMETER_PRODUCT_INFO));
		name.set(productInfo.get(0));
		price.set(productInfo.get(1));
		theNumber.set(productInfo.get(2));
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.inBracket(input);

		SplitChecker splitChecker = new SplitChecker();
		splitChecker.exceedMaxSplit(input, Rule.DELIMETER_PRODUCT_INFO);
		splitChecker.hasZeroLength(input, Rule.DELIMETER_PRODUCT_INFO);
		splitChecker.isCorrectTheNumber(input, Rule.DELIMETER_PRODUCT_INFO, Rule.NUMBER_OF_PRODUCT_INFO);
	}
}
