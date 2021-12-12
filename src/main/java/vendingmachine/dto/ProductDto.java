package vendingmachine.dto;

import java.util.Arrays;

import vendingmachine.constant.Notification;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

public class ProductDto {
	private static final int PRODUCT_COMPOSITION_SIZE = 3;
	private static final int PRODUCT_START_INDEX = 1;
	private static final int PRODUCT_MINIMUM_SIZE = 1;
	private static final char PRODUCTS_SPLIT = ';';
	private static final String PRODUCT_COMPOSITION_SPLIT = ",";
	private static final String PRODUCT_START_STRING = "[";
	private static final String PRODUCT_END_STRING = "]";


	private final String input;

	public ProductDto(String input) {
		this.input = input;
	}

	public Products convertProducts() {
		long productSize = getProductSize();
		String[] productArray = input.split(String.valueOf(PRODUCTS_SPLIT));
		validProductSize(productArray);
		validateSizeDifference(productArray.length, productSize);
		Products products = Products.from();
		for (String product : productArray) {
			products.add(convertProduct(product));
		}
		return products;
	}

	private void validateSizeDifference(int length, long productSize) {
		if(length != productSize+1) {
			throw new IllegalArgumentException(Notification.PRODUCT_INVALID_COMPOSITION.getMessage());
		}
	}

	private long getProductSize() {
		return input.chars()
			.filter(ch -> ch == PRODUCTS_SPLIT)
			.count();
	}

	private void validProductSize(String[] productArray) {
		if (productArray.length < PRODUCT_MINIMUM_SIZE) {
			throw new IllegalArgumentException(Notification.PRODUCTS_SIZE_INSUFFICIENT.getMessage());
		}
	}

	private Product convertProduct(String product) {
		product = removePattern(product);
		String[] productElements = product.split(PRODUCT_COMPOSITION_SPLIT);
		validateSize(productElements.length);
		return createProduct(productElements);
	}

	private Product createProduct(String[] productElements) {
		String name = productElements[0];
		String price = productElements[1];
		String quantity = productElements[2];
		return Product.of(name, price, quantity);
	}

	private String removePattern(String product) {
		validatePattern(product);
		return product.substring(PRODUCT_START_INDEX, product.length() - 1);
	}

	private void validateSize(int productSize) {
		if (productSize != PRODUCT_COMPOSITION_SIZE) {
			throw new IllegalArgumentException(Notification.PRODUCT_INVALID_COMPOSITION.getMessage());
		}
	}

	private void validatePattern(String product) {
		if (!product.startsWith(PRODUCT_START_STRING) || !product.endsWith(PRODUCT_END_STRING)) {
			throw new IllegalArgumentException(Notification.PRODUCT_INVALID_COMPOSITION.getMessage());
		}
	}
}
