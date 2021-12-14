package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.utils.message.ErrorMessage;

public class Products {
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;
	private static final String PRODUCT_SPLIT_DELIMITER = ",";
	private static final int OUT_OF_STOCK = 0;
	private static final int NO_PRICE = 0;

	private final List<Product> productList = new ArrayList<>();

	public Products() {
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
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR_PRODUCT_DOES_NOT_EXIST.getText()));
	}

	public void createProductList(List<String> productInfoList) {

		for (String product : productInfoList) {
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

	public boolean checkStock(int currentMoney) {
		for (Product product : productList) {
			if ((product.getQuantity() > OUT_OF_STOCK) && product.getPrice() <= currentMoney) {
				return true;
			}
		}
		return false;
	}

}
