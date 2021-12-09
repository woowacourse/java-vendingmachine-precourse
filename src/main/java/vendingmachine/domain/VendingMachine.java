package vendingmachine.domain;

import static vendingmachine.constant.Constant.*;

import java.util.HashMap;

public class VendingMachine {
	private final HashMap<String, Integer> productPrice = new HashMap<>();
	private final HashMap<String, Integer> productStocks = new HashMap<>();

	public void addProduct(String products) {
		for (String productPriceAndStock : products.split(DISTINGUISH_BETWEEN_PRODUCTS)) {
			String[] product = productPriceAndStock.split(DISTINGUISH_BETWEEN_PRODUCT_INFORMATION);
			// validateProduct(product);
			productPrice.put(product[NAME], Integer.parseInt(product[PRICE]));
			productStocks.put(product[NAME], Integer.parseInt(product[STOCKS]));
		}
	}

	private void sellProduct(String productName, int amountPaid) {
		if (!canSell()) {
			return;
		}
		productStocks.put(productName, productStocks.get(productName) - 1);
		giveChange(amountPaid);
	}

}
