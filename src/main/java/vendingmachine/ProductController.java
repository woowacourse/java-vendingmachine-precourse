package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Products;
import vendingmachine.validator.Validator;
import vendingmachine.view.Input;

public class ProductController {
	public static Products getProducts() {
		while (true) {
			Products products = makeProducts();
			if (products != null)
				return products;
		}
	}

	private static Products makeProducts() {
		try {
			List<String> productsInfoList = Input.getProductsInfo();
			Validator.validateProductsInputFormat(productsInfoList);

			List<List<String>> splitLists = getSplitLists(productsInfoList);
			Validator.validateEachProduct(splitLists);

			Products products = new Products(splitLists);
			return products;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	private static List<List<String>> getSplitLists(List<String> productsInfoList) {
		List<List<String>> splitLists = new ArrayList<>();
		for (String info : productsInfoList) {
			splitLists.add(
				Arrays.stream(info.substring(1, info.length() - 1).split(","))
					.map(String::trim)
					.collect(Collectors.toList())
			);
		}
		return splitLists;
	}
}
