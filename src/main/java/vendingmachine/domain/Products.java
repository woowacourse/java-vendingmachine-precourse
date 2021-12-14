package vendingmachine.domain;

import static vendingmachine.resource.MessageResource.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Products {
	private static final int PRODUCT_ARRAY_LENGTH = 3;
	private static final String SEMICOLON = ";";
	private static final String COMMA = ",";
	private static final String LEFT_SQUARE_BRACKETS = "[";
	private static final String RIGHT_SQUARE_BRACKETS = "]";

	private final List<Product> products;

	public Products(String inputProducts) {
		this.products = createProducts(inputProducts);
	}

	public void buyProduct(String productName, Money money) {
		Product product = findByProductName(productName);
		money.deduct(product.getPrice());
		product.reduceCount();
	}

	public boolean hasNotProductsCount() {
		return products.stream()
			.allMatch(Product::isSoldOut);
	}

	public boolean canBuyCurrentAmount(int currentAmount) {
		return products.stream()
			.filter(product -> !product.isSoldOut())
			.map(Product::getPrice)
			.min(Integer::compareTo)
			.orElse(0) <= currentAmount;
	}

	private Product findByProductName(String productName) {
		return products.stream()
			.filter(product -> product.getName().equals(productName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_PRODUCT_NAME));
	}

	private List<Product> createProducts(String inputProducts) {
		String[] split = inputProducts.split(SEMICOLON);
		checkFormat(split);

		List<Product> productList = Arrays.stream(split)
			.map(str -> new Product(getProductSplit(str)))
			.collect(Collectors.toList());

		isDuplicated(productList);

		return productList;
	}

	private void isDuplicated(List<Product> productList) {
		if (productList.size() != productList.stream()
			.map(Product::getName)
			.distinct().count()) {
			throw new IllegalArgumentException(ERROR_PRODUCT_NAME_DUPLICATED);
		}
	}

	private String[] getProductSplit(String str) {
		String[] item = str.substring(1, str.length() - 1).split(COMMA);
		if (item.length != PRODUCT_ARRAY_LENGTH) {
			throw new IllegalArgumentException(ERROR_INPUT_PRODUCT_NOT_VALID);
		}
		return item;
	}

	private void checkFormat(String[] split) {
		for (String s : split) {
			if (!(s.startsWith(LEFT_SQUARE_BRACKETS) && s.endsWith(RIGHT_SQUARE_BRACKETS))) {
				throw new IllegalArgumentException(ERROR_PRODUCT_NOT_SQUARE_BRACKETS);
			}
		}
	}
}
