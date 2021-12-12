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
}
