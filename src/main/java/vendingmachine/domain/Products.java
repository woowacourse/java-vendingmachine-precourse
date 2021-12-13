package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

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
	private static final long NO_DUPLICATE_CASE = 1;

	private List<Product> products = new ArrayList<>();

	public Products(String input) {
		List<Product> newProducts = toProductList(input);
		validateDuplicateName(newProducts);
		products.addAll(newProducts);
	}

	public void save() {
		validateNotRegisteredProduct();
		products.forEach(ProductRepository::save);
	}

	private List<Product> toProductList(String input) {
		List<Product> newProducts = new ArrayList<>();
		for (String individualInput : input.split(SEPARATOR)) {
			Matcher matcher = PATTERN.matcher(individualInput);
			validateRegex(matcher);
			Name name = new Name(matcher.group(NAME_INDEX));
			Money price = new Money(matcher.group(PRICE_INDEX));
			Quantity quantity = new Quantity(matcher.group(QUANTITY_INDEX));
			newProducts.add(new Product(name, price, quantity));
		}
		return newProducts;
	}

	private void validateRegex(Matcher matcher) {
		if (!matcher.find()) {
			throw new IllegalArgumentException(PRODUCT_INVALID_FORMAT_ERROR_MESSAGE.get());
		}
	}

	private void validateDuplicateName(List<Product> newProducts) {
		for (Product newProduct : newProducts) {
			long count = newProducts.stream()
				.filter(product -> product.isSameName(newProduct))
				.count();
			if (count != NO_DUPLICATE_CASE) {
				throw new IllegalArgumentException(PRODUCT_DUPLICATE_NAME_ERROR_MESSAGE.get());
			}
		}
	}

	private void validateNotRegisteredProduct() {
		if (products.stream().anyMatch(ProductRepository::contains)) {
			throw new IllegalArgumentException(PRODUCT_ALREADY_REGISTERED_ERROR_MESSAGE.get());
		}
	}
}
