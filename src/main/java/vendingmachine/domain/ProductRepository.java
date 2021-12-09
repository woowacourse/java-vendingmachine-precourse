package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
	private static final List<Product> productList = new ArrayList<>();

	public void createProducts(List<String> productListString) {
		for (String productString: productListString) {
			addProductByString(splitProductStringByDelimiter(productString));
		}
	}

	private List<String> splitProductStringByDelimiter(String productToString) {
		return Arrays.stream(productToString.split(DELIMITER_PRODUCT_STRING))
			.collect(Collectors.toList());
	}

	private void addProductByString(List<String> productString) {
		productList.add(new Product(productString));
	}
}
