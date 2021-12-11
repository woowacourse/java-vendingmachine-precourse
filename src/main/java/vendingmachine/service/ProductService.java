package vendingmachine.service;

import static constant.CharacterConstant.*;
import static constant.StringConstant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import vendingmachine.model.Product;

public class ProductService {
	public List<Product> stringToProductList(String userProducts) {
		List<String> productInfos = Arrays.asList(userProducts.split(PRODUCT_DIVIDER));
		List<Product> productList = new ArrayList<>();
		for (String productInfo : productInfos) {
			Product product = stringToProduct(unwrapProductInfo(productInfo));
			productList.add(product);
		}
		return productList;
	}

	private String unwrapProductInfo(String product) {
		return product.substring(1, product.length() - 1);
	}

	private Product stringToProduct(String product) {
		String[] productInfo = product.split(PRODUCT_DETAIL_DIVIDER);
		String productName = productInfo[0];
		int productPrice = Integer.parseInt(productInfo[1]);
		int productQuantity = Integer.parseInt(productInfo[2]);
		return new Product(productName, productPrice, productQuantity);
	}

	public Product findByName(List<Product> productList, String name) {
		Optional<Product> orderedProduct = Optional.ofNullable(
			productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null)
		);
		return orderedProduct.orElseThrow(
			() -> new IllegalArgumentException(ORDER_NOT_EXIST)
		);
	}

}
