package vendingmachine.domain.product;

import static vendingmachine.constant.SystemMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.validator.ProductValidator;

public class ProductService {
	public List<Product> makeProducts(String unprocessedProducts) {
		List<String> unprocessedProductList = toList(unprocessedProducts);
		unprocessedProductList.forEach(ProductValidator::checkProduct);
		return unprocessedProductList.stream()
			.map(unprocessedProduct -> unprocessedProduct.substring(1, unprocessedProduct.length() - 1)
				.split(NAME_COST_STOCK_DELIMITER))
			.map(product -> new Product(new ProductName(product[NAME]),
				new ProductAmount(Integer.parseInt(product[AMOUNT])),
				new ProductStock(Integer.parseInt(product[STOCK]))))
			.collect(Collectors.toList());
	}

	private List<String> toList(String inputProduct) {
		return Arrays.asList(inputProduct.split(PRODUCT_DELIMITER));
	}
}
