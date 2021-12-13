package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.ProductCandidate;
import vendingmachine.domain.ProductSet;
import vendingmachine.validation.RegexMatchValidation;
import vendingmachine.validation.StringExistValidation;
import vendingmachine.validation.Validator;

public class ProductSplitService implements SplitService {

	private static final String PRODUCT_SET_DELIMITER = ";";
	private static final Pattern PRODUCT_PATTERN =
		Pattern.compile("^\\[(?<name>.+?),(?<price>.+?),(?<quantity>.+?)]$");

	@Override
	public List<ProductCandidate> splitProducts(String input) {
		Validator.validate(ProductSet.NAME, input, new StringExistValidation());
		return Arrays.stream(input.split(PRODUCT_SET_DELIMITER))
			.map(this::splitProduct)
			.collect(Collectors.toList());
	}

	private ProductCandidate splitProduct(String input) {
		Matcher matcher = PRODUCT_PATTERN.matcher(input);
		Validator.validate(Product.NAME, matcher, new RegexMatchValidation());
		return new ProductCandidate(
			matcher.group("name"),
			matcher.group("price"),
			matcher.group("quantity")
		);
	}
}
