package vendingmachine.model;

import static vendingmachine.constant.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class Products {

	public List<Product> products = new ArrayList<>();

	public Products(String requestProduct) {
		String[] productsSplitBySemeColon = requestProduct.split(SEME_COLON);
		for (String product : productsSplitBySemeColon) {
			String[] productSplitByFormat = product.replace(LEFT_PARENTHESIS, BLANK)
				.replace(RIGHT_PARENTHESIS, BLANK)
				.split(COMMA);
			products.add(new Product(productSplitByFormat));
		}
	}

	public List<Product> getProducts() {
		return products;
	}
}
