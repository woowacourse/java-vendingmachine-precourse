package productcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {
	private static final String PRODUCT_FEATURE_DIVIDER = ",";
	private static final String PRODUCT_DIVIDER = ";";
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int STOCK_INDEX = 2;

	private ArrayList<Product> vendingMachineProducts;
	private ProductRuleChecker productRuleChecker;

	public ProductController() {
		vendingMachineProducts = new ArrayList<>();
		productRuleChecker = new ProductRuleChecker();
	}

	private String offBracket(String target) {
		return target.substring(1, target.length() - 1);
	}

	private void makeProductInstance(String product) {
		product = offBracket(product);
		List<String> productFeature = Arrays.asList(product.split(PRODUCT_FEATURE_DIVIDER));
		vendingMachineProducts.add(
			new Product(productFeature.get(NAME_INDEX), Integer.parseInt(productFeature.get(PRICE_INDEX)),
				Integer.parseInt(productFeature.get(STOCK_INDEX))));
	}

	public void setNewProducts(String products) {
		List<String> productBucket = Arrays.asList(products.split(PRODUCT_DIVIDER));
		for (String product : productBucket) {
			makeProductInstance(product);
		}
	}
}
