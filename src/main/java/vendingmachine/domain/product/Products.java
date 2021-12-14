package vendingmachine.domain.product;

import static vendingmachine.constant.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private List<Product> products;

	public Products() {
		products = new ArrayList<>();
	}

	public void add(Product product) {
		if (hasSameName(product)) {
			throw new IllegalArgumentException(DUPLICATE_NAME_EXIST_ERROR_MESSAGE);
		}
		products.add(product);
	}

	private boolean hasSameName(Product product) {
		return products.stream()
			.anyMatch(product::equals);
	}

	public boolean hasAnyProducts() {
		return products.stream()
			.anyMatch(Product::hasStock);
	}

	public Product getCheapestProduct() {
		return products.stream()
			.filter(Product::hasStock)
			.min(Product::compareTo)
			.orElseThrow(() -> new IllegalAccessError(SOLD_OUT_ERROR_MESSAGE));
	}

	public Product getProductByName(ProductName productName) {
		return products.stream()
			.filter(product -> product.hasName(productName))
			.filter(Product::hasStock)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(PRODUCT_IS_NOT_EXISTENT_ERROR_MESSAGE));
	}
}
