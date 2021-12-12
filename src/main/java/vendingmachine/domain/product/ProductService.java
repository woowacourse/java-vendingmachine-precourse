package vendingmachine.domain.product;

import static vendingmachine.constant.SystemMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
	public List<Product> makeProducts(String unprocessedProducts) {
		List<String> unprocessedProductList = toList(unprocessedProducts);
		return unprocessedProductList.stream()
			.map(Product::new)
			.collect(Collectors.toList());
	}

	private List<String> toList(String inputProduct) {
		return Arrays.asList(inputProduct.split(PRODUCT_DELIMITER));
	}
}
