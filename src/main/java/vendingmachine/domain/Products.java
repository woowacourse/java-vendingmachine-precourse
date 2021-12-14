package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;

public class Products {

	private final List<Product> products;

	public Products(String inputProducts) {
		this.products = validateAndCreateProducts(inputProducts);
	}

	private List<Product> validateAndCreateProducts(String inputProducts) {
		List<Product> productList = Arrays.stream(inputProducts.split(Constant.DELIMITER))
			.map(Product::fromProductInformation)
			.collect(Collectors.toList());
		if (isDuplicate(productList)) {
			throw new IllegalArgumentException(Message.ERROR_DUPLICATE_PRODUCT);
		}
		return productList;
	}

	public boolean isDuplicate(List<Product> productList) {
		return productList.size() != new HashSet<>(productList).size();
	}

	public int findMinimumProductPrice() {
		return products.stream()
			.filter(product -> product.getQuantity() > Constant.ZERO)
			.map(Product::getPrice)
			.min((Comparator.comparingInt(o -> o)))
			.orElseThrow(() -> new IllegalArgumentException(Message.ERROR_NOT_FOUND_PRODUCT));
	}

	public Product findProduct(String purchaseProductName) {
		return products.stream()
			.filter(product -> product.getName().equals(purchaseProductName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.ERROR_NO_PRODUCT));
	}
}
