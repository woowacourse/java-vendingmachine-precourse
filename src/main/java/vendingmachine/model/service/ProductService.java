package vendingmachine.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.model.domain.Product;
import vendingmachine.util.Constant;
import vendingmachine.util.Utils;
import vendingmachine.validator.Validator;

public class ProductService {

	public Product createDetailProduct(String productInformation) throws IllegalArgumentException {
		productInformation = productInformation.replace(Constant.OPEN_SQUARE_BRACKET, "")
			.replace(Constant.CLOSING_SQUARE_BRACKET, "");
		String[] productInfo = productInformation.split(Constant.PRODUCT_DETAIL_SEPARATOR);

		Validator.validateProduct(productInfo);

		String name = productInfo[0];
		int price = Utils.moneyConverter(productInfo[1]);
		int amount = Integer.parseInt(productInfo[2]);

		return new Product(name, price, amount);
	}

	public List<Product> createProduct(String products) {
		return Arrays.stream(products.split(Constant.PRODUCT_SEPARATOR))
			.map(this::createDetailProduct)
			.collect(Collectors.toList());
	}

	public Product findProductByName(String productName, List<Product> productList) {
		return productList.stream()
			.filter(it -> it.getEqualProduct(productName))
			.findFirst()
			.map(Product::purchaseProduct)
			.orElseThrow(() -> new IllegalArgumentException(Validator.ERROR_NOT_EXISTED_PRODUCT));
	}
}
