package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import vendingmachine.constant.Rule;
import vendingmachine.util.SplitChecker;
import vendingmachine.util.StringChecker;

public class Product {

	private Name name;
	private Price price;
	private TheNumber theNumber;

	public Product(String input) {
		checkInput(input);
		String inputWithoutBracket = input.substring(1, input.length() - 1);
		List<String> productInfo = Arrays.asList(inputWithoutBracket.split(Rule.DELIMITER_PRODUCT_INFO));
		name = new Name(productInfo.get(0));
		price = new Price(productInfo.get(1));
		theNumber = new TheNumber(productInfo.get(2));
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.inBracket(input);
		String inputWithoutBracket = input.substring(1, input.length() - 1);

		SplitChecker splitChecker = new SplitChecker();
		splitChecker.exceedMaxSplit(inputWithoutBracket, Rule.DELIMITER_PRODUCT_INFO);
		splitChecker.hasZeroLength(inputWithoutBracket, Rule.DELIMITER_PRODUCT_INFO);
		splitChecker.isCorrectTheNumber(inputWithoutBracket, Rule.DELIMITER_PRODUCT_INFO, Rule.NUMBER_OF_PRODUCT_INFO);
	}

	public Name getName() {
		return name;
	}

	public Price getPrice() {
		return price;
	}

	public boolean theNumberIsZero() {
		return theNumber.isZero();
	}

	public void minusTheNumber() {
		theNumber.minus();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Name: " + name.get());
		stringBuilder.append(", Price: " + price.get());
		stringBuilder.append(", theNumber: " + theNumber.get());
		return stringBuilder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Product other = (Product)obj;
		if (!name.equals(other.name)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
}
