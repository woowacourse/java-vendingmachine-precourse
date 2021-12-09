package exception;

import static constant.CharacterConstant.*;
import static constant.NumberConstant.*;
import static constant.StringConstant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.model.Product;

public class ProductException {
	public static List<Product> isValidProduct(String userProducts) {
		List<String> products = Arrays.asList(userProducts.split(PRODUCT_DIVIDER));
		List<Product> productList = new ArrayList<>();
		for (String product : products) {
			Product normalProduct = isWrapped(product);
			productList.add(normalProduct);
		}
		isDuplicated(productList);
		return productList;
	}

	private static Product isWrapped(String userProduct) {
		if (userProduct.startsWith(PRODUCT_WRAPPER_LEFT)
				&& userProduct.endsWith(PRODUCT_WRAPPER_RIGHT)) {
			userProduct = userProduct.substring(1, userProduct.length() - 1);
			return isProduct(userProduct);
		}
		throw new IllegalArgumentException(PRODUCT_WRAPPER_NULL);
	}

	private static Product isProduct(String userProduct) {
		List<String> productDetail = Arrays.asList(userProduct.split(PRODUCT_DETAIL_DIVIDER));
		if (productDetail.size() == PRODUCT_DETAIL_AMOUNT) {
			return createProduct(productDetail);
		}
		throw new IllegalArgumentException(PRODUCT_DETAIL_UNMATCHED);
	}

	private static Product createProduct(List<String> productDetail) {
		String productName = productDetail.get(0);
		int productPrice = isValidPrice(productDetail.get(1));
		int productQuantity = isValidQuantity(productDetail.get(2));
		return new Product(productName, productPrice, productQuantity);
	}

	private static int isValidPrice(String productPrice) {
		try {
			int price = PriceException.isValidPrice(productPrice);
			return price;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(PRODUCT_PRICE_PREFIX + e.getMessage());
		}
	}

	private static int isValidQuantity(String productQuantity) {
		try {
			int quantity = QuantityException.isValidQuantity(productQuantity);
			return quantity;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(PRODUCT_QUANTITY_PREFIX + e.getMessage());
		}
	}

	private static void isDuplicated(List<Product> productList) {
		List<String> productNames = new ArrayList<>();
		for (Product product : productList) {
			productNames.add(product.getName());
		}
		int distinctSize =
			productNames.stream()
			.map(productName -> productName.trim())
			.distinct()
			.collect(Collectors.toList()).size();
		if (productNames.size() != distinctSize) {
			throw new IllegalArgumentException(PRODUCT_NAME_DUPLICATED);
		}
	}
}
