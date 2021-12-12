package vendingmachine.domain.product;

import static vendingmachine.constant.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public boolean hasSameName(Product product) {
		return products.stream()
			.anyMatch(product::equals);
	}

	public Product getProductByName(ProductName productName) {
		List<Product> targetProduct = products.stream()
			.filter(product -> product.hasName(productName))
			.filter(Product::hasStock)
			.collect(Collectors.toList());
		if (isNotExistProduct(targetProduct)) {
			throw new IllegalArgumentException(PRODUCT_IS_NOT_EXISTENT_ERROR_MESSAGE);
		}
		return targetProduct.get(0);
	}

	private boolean isNotExistProduct(List<Product> targetProduct) {
		return targetProduct.size() == 0;
	}
}
