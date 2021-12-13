package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import vendingmachine.utils.ValidateUtils;

public class Products {

	private static final String ERROR_DUPLICATE_PRODUCT = "중복된 상품입니다.";
	private static final String ERROR_INVALID_PRODUCT_PRICE = "상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 합니다.";
	private static final String ERROR_INVALID_PRODUCT_INPUT_TYPE = "상품 정보 입력 형식을 다시 확인해주세요";
	private static final String ERROR_NO_PRODUCT = "존재하지 않는 상품입니다.";
	private static final String ERROR_NOT_FOUND_PRODUCT = "구매 가능한 상품이 없습니다.";
	private static final int ZERO = 0;
	private static final int DIVIDE_NUMBER = 10;
	private static final int MIN_PRODUCT_PRICE = 100;
	private static final int PRODUCT_INFORMATION = 3;
	private static final String COMMA = ",";
	private static final String DELIMITER = ";";

	private final List<Product> products;

	public Products(String inputProducts) {
		this.products = new ArrayList<>();
		validateInputProducts(inputProducts);
	}

	private void validateInputProducts(String inputProducts) {
		for (String product : inputProducts.split(DELIMITER)) {
			isValidInputType(product);
			String[] productInformation = splitProductInformation(product);
			String name = productInformation[0];
			String price = productInformation[1];
			String quantity = productInformation[2];
			isDuplicate(name);
			isDigit(price, quantity);
			isValidPrice(Integer.parseInt(price));
			addProduct(name, Integer.parseInt(price), Integer.parseInt(quantity));
		}
	}

	private void addProduct(String name, int price, int quantity) {
		products.add(new Product(name, price, quantity));
	}

	private void isValidInputType(String product) {
		if (product.charAt(ZERO) != '[' || product.charAt(product.length() - 1) != ']'
			|| product.split(COMMA).length != PRODUCT_INFORMATION) {
			throw new IllegalArgumentException(ERROR_INVALID_PRODUCT_INPUT_TYPE);
		}
	}

	private void isDuplicate(String productName) {
		if (products.contains(productName)) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_PRODUCT);
		}
	}

	private void isDigit(String price, String quantity) {
		ValidateUtils.isDigit(price);
		ValidateUtils.isDigit(quantity);
	}

	private void isValidPrice(int productPrice) {
		if (productPrice < MIN_PRODUCT_PRICE || productPrice % DIVIDE_NUMBER != ZERO) {
			throw new IllegalArgumentException(ERROR_INVALID_PRODUCT_PRICE);
		}
	}

	private String[] splitProductInformation(String product) {
		return product.substring(1, product.length() - 1).split(COMMA);
	}

	public int findMinimumProductPrice() {
		return products.stream()
			.filter(product -> product.getQuantity() > ZERO)
			.map(product -> product.getPrice())
			.min((Comparator.comparingInt(o -> o)))
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_PRODUCT));
	}

	public Product findProduct(String purchaseProductName) {
		return products.stream()
			.filter(product -> product.getName().equals(purchaseProductName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NO_PRODUCT));
	}
}
