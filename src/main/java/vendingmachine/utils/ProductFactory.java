package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Product;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProductFactory {

	private static final String PRODUCTS_DELIMITER = ";";

	public static List<Product> makeProducts() {
		String inputProductsInfo = InputView.writeProductsInfo();
		List<String> productsInfo = Arrays.asList(inputProductsInfo.split(PRODUCTS_DELIMITER));
		try {
			return productsInfo.stream()
				.map(Product::new)
				.collect(Collectors.toList());
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return makeProducts();
		}
	}
}
