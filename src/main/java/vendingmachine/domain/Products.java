package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Products {

	private static final String ERROR_DUPLICATE_PRODUCT = "중복된 상품입니다.";
	private static final String ERROR_NO_PRODUCT = "존재하지 않는 상품입니다.";
	private static final String ERROR_NOT_FOUND_PRODUCT = "구매 가능한 상품이 없습니다.";
	private static final String ERROR_INVALID_PRODUCT_INPUT_TYPE = "상품 정보 입력 형식을 다시 확인해주세요";
	private static final char OPEN_BRACKET = '[';
	private static final char CLOSE_BRACKET = ']';
	private static final String COMMA = ",";
	private static final String DELIMITER = ";";
	private static final int PRODUCT_INFORMATION_LENGTH = 3;
	private static final int ZERO = 0;

	private final List<Product> products;

	public Products(String inputProducts) {
		this.products = validateAndCreateProducts(inputProducts);
	}

	private List<Product> validateAndCreateProducts(String inputProducts) {
		if (!isValidInputType(inputProducts)) {
			throw new IllegalArgumentException(ERROR_INVALID_PRODUCT_INPUT_TYPE);
		}
		List<Product> productList = Arrays.stream(inputProducts.split(DELIMITER))
			.map(Product::fromProductInformation)
			.collect(Collectors.toList());
		if (isDuplicate(productList)) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_PRODUCT);
		}
		return productList;
	}

	public boolean isValidInputType(String product) {
		return product.charAt(ZERO) == OPEN_BRACKET
			&& product.charAt(product.length() - 1) == CLOSE_BRACKET
			&& product.split(COMMA).length == PRODUCT_INFORMATION_LENGTH;
	}

	public boolean isDuplicate(List<Product> productList) {
		return productList.size() != new HashSet<>(productList).size();
	}

	public int findMinimumProductPrice() {
		return products.stream()
			.filter(product -> product.getQuantity() > ZERO)
			.map(Product::getPrice)
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
