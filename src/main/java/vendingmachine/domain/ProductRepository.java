package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	private static final List<Product> products = new ArrayList<>();

	public static void save(Product product) {
		products.add(product);
	}

	public static Product findByName(Name name) {
		return products.stream()
			.filter(product -> product.isSameName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NO_SAME_NAME_PRODUCT_ERROR_MESSAGE.get()));
	}

	public static boolean canSell() {
		return products.stream()
			.anyMatch(Product::canSell);
	}

	public static void clear() {
		products.clear();
	}
}
