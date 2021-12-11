package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;

	private static final String INPUT_SPLIT_DELIMITER = ";";
	private static final String PRODUCT_SPLIT_DELIMITER = ",";

	private static final int OUT_OF_STOCK = 0;
	private static final int NO_PRICE = 0;

	private List<Product> productList = new ArrayList<>();

	public Products() {
	}

	public List<Product> getProductList() {
		return productList;
	}

	public int getMinPriceProduct() {
		return productList.stream().mapToInt(Product::getPrice).min().orElse(NO_PRICE);
	}

	public boolean checkStockAndSellProduct(String productName) {
		Product productToSell = getProductByName(productName);
		if (productToSell.getQuantity() != OUT_OF_STOCK) {
			productToSell.reduceQuantity();
			return true;
		}
		return false;
	}

	public Product getProductByName(String productName) {
		return productList.stream()
			.filter(product -> product.getName().equals(productName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	public void createProductList(String input) {
		List<String> inputList = Arrays.asList(input.split(INPUT_SPLIT_DELIMITER));

		for (String product : inputList) {
			String productInfo = product.substring(1, product.length() - 1);
			addProduct(Arrays.asList(productInfo.split(PRODUCT_SPLIT_DELIMITER)));
		}
	}

	public void addProduct(List<String> productInfo) {
		String name = productInfo.get(NAME_INDEX);
		int price = Integer.parseInt(productInfo.get(PRICE_INDEX));
		int quantity = Integer.parseInt(productInfo.get(QUANTITY_INDEX));
		productList.add(new Product(name, price, quantity));
	}

}
