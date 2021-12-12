package vendingmachine.dto;

import vendingmachine.constant.Notification;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

public class ProductDto {
	private static final int PRODUCT_COMPOSITION_SIZE = 3;
	private static final int PRODUCT_START_INDEX = 1;
	private static final int PRODUCT_MINIMUM_SIZE = 1;

	private final String input;

	public ProductDto(String input) {
		this.input = input;
	}

	public Products convertProducts() {
		String[] productArray = input.split(";");
		validProductSize(productArray);
		Products products = Products.from();
		for (String product : productArray) {
			products.add(convertProduct(product));
		}
		return products;
	}

	private void validProductSize(String[] productArray) {
		if (productArray.length < PRODUCT_MINIMUM_SIZE) {
			throw new IllegalArgumentException(Notification.PRODUCTS_SIZE_INSUFFICIENT.getMessage());
		}
	}

	private Product convertProduct(String product) {
		product = removePattern(product);
		String[] productElements = product.split(",");
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
		if (!product.startsWith("[") || !product.endsWith("]")) {
			throw new IllegalArgumentException(Notification.PRODUCT_INVALID_COMPOSITION.getMessage());
		}
	}
}
