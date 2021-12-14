package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.validator.Validator;
import vendingmachine.view.Input;

public class ProductsController {
	static final String MSG_DUPLICATION_ERROR = "[ERROR] 상품명은 중복될 수 없다.";
	static final int PRODUCT_INPUT_AFFIX_LENGTH = 1;
	static final String PRODUCT_INFO_REGEX = ",";

	public static Products getProducts() {
		Products products;
		do {
			products = makeProducts();
		} while (products == null);
		return products;
	}

	private static Products makeProducts() {
		try {
			List<String> productsInfo = getProductsInfo();
			List<List<String>> productsInfoLists = getProductsInfoLists(productsInfo);

			Products products = new Products();
			addProduct(products, productsInfoLists);
			return products;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private static List<String> getProductsInfo() {
		List<String> productsInfo = Input.productsInfo();
		Validator.validateProductsInputFormat(productsInfo);
		return productsInfo;
	}

	private static List<List<String>> getProductsInfoLists(List<String> productsInfo) {
		List<List<String>> productsInfoLists = new ArrayList<>();
		for (String info : productsInfo) {
			productsInfoLists.add(splitInformation(info));
		}
		Validator.validateEachProduct(productsInfoLists);
		return productsInfoLists;
	}

	private static List<String> splitInformation(String info) {
		return Arrays.stream(info.substring(PRODUCT_INPUT_AFFIX_LENGTH,
					info.length() - PRODUCT_INPUT_AFFIX_LENGTH)
				.split(PRODUCT_INFO_REGEX))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private static void addProduct(Products products, List<List<String>> productsInfoList) {
		for (List<String> productInfo : productsInfoList) {
			Product product = new Product(productInfo);
			validateProductDuplication(products, product);
			products.add(product);
		}
	}

	private static void validateProductDuplication(Products products, Product product) {
		if (products.isContains(product)) {
			throw new IllegalArgumentException(MSG_DUPLICATION_ERROR);
		}
	}
}
