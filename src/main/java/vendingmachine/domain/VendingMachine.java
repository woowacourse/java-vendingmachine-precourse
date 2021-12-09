package vendingmachine.domain;

import static vendingmachine.constant.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class VendingMachine {

	private final HashMap<String, Object> productsPriceAndStocks = new HashMap<>();

	public void addProduct(String products) {
		for (String productPriceAndStock : products.split(DISTINGUISH_BETWEEN_PRODUCTS)) {
			String[] product = productPriceAndStock.split(DISTINGUISH_BETWEEN_PRODUCT_INFORMATION);
			// validateProduct(product);
			productsPriceAndStocks.put(product[NAME],
				new ArrayList<>(Arrays.asList(Integer.parseInt(product[PRICE]), Integer.parseInt(product[STOCKS]))));
		}

	}
}
