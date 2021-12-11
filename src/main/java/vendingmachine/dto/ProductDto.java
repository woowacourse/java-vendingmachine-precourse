package vendingmachine.dto;

import vendingmachine.Notification;

public class ProductDto {
	private static final int PRODUCT_COMPOSITION_SIZE = 3;
	private static final int PRODUCT_START_INDEX = 1;

	private final String input;

	public ProductDto(String input) {
		this.input = input;
	}

	public void convertProducts() {
		String[] products = input.split(";");
		for (String product : products) {
			convertProduct(product);
		}
	}

	private void convertProduct(String product) {
		product = removePattern(product);
		String[] productElements = product.split(",");
		validateSize(productElements.length);
		createProduct(productElements);
	}

	private void createProduct(String[] productElements) {
		String name = productElements[0];
		String price = productElements[1];
		String quantity = productElements[2];
	}

	private String removePattern(String product) {
		validatePattern(product);
		return product.substring(PRODUCT_START_INDEX,product.length()-1);
	}

	private void validateSize(int productSize) {
		if(productSize != PRODUCT_COMPOSITION_SIZE) {
			throw new IllegalArgumentException(Notification.PRODUCT_INVALID_COMPOSITION.getMessage());
		}
	}

	private void validatePattern(String product) {
		if(!product.startsWith("[") || !product.endsWith("]")){
			throw new IllegalArgumentException(Notification.PRODUCT_INVALID_COMPOSITION.getMessage());
		}
	}
}
