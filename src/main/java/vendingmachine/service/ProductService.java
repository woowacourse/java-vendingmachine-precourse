package vendingmachine.service;

import static constant.CharacterConstant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.model.Product;

public class ProductService {
	public static List<Product> stringToProductList(String userProducts) {
		List<String> productInfos = Arrays.asList(userProducts.split(PRODUCT_DIVIDER));
		List<Product> productList = new ArrayList<>();
		for (String productInfo : productInfos) {
			Product product = stringToProduct(unwrapProductInfo(productInfo));
			productList.add(product);
		}
		return productList;
	}

	private static String unwrapProductInfo(String product) {
		return product.substring(1, product.length() - 1);
	}

	private static Product stringToProduct(String product) {
		String[] productInfo = product.split(PRODUCT_DETAIL_DIVIDER);
		String productName = productInfo[0];
		int productPrice = Integer.parseInt(productInfo[1]);
		int productQuantity = Integer.parseInt(productInfo[2]);
		return new Product(productName, productPrice, productQuantity);
	}
}
