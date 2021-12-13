package vendingmachine.domain.product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import vendingmachine.domain.machine.Balance;

public class Products {
	private static final String ERROR_PRODUCTS_DUPLICATED = "상품 구성에 중복되는 상품이 있습니다.";
	private static final String ERROR_PRODUCT_NOT_REGISTER = "등록되지 않은 상품 입니다.";

	private List<Product> products;

	private Products(List<Product> products) {
		isValidateDuplicated(products);
		this.products = products;
	}

	public static Products from(List<String> inputProducts) {
		return new Products(inputProducts.stream()
			.map(Product::from)
			.collect(Collectors.toList()));
	}

	private void isValidateDuplicated(List<Product> products) {
		final Set<Product> distinctProductsName = products.stream()
			.collect(Collectors.toSet());

		if (distinctProductsName.size() != products.size()) {
			throw new IllegalArgumentException(ERROR_PRODUCTS_DUPLICATED);
		}
	}

	public boolean isValidateProductsPurchase(Balance balance) {
		return products.stream()
			.noneMatch(product -> product.isValidateProductPurchase(balance));
	}

	public Product isCheckSameProduct(String productName) {
		return products.stream()
			.filter(product -> product.isValidateSameProduct(productName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_PRODUCT_NOT_REGISTER));
	}
}
