package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Product;
import vendingmachine.utils.exception.ProductException;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProductFactory {

	private static final String PRODUCTS_DELIMITER = ";";

	public static List<Product> makeProducts() {
		String inputProductsInfo = InputView.writeProductsInfo();
		List<String> productsInfo = Arrays.asList(inputProductsInfo.split(PRODUCTS_DELIMITER));
		try {
			List<Product> products = productsInfo.stream()
				.map(Product::new)
				.collect(Collectors.toList());
			ProductException.validateDuplicatedName(products);
			return products;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return makeProducts();
		}
	}
}
