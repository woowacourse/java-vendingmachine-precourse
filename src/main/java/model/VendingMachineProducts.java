package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachineProducts {
	private static final String COMMA = ",";
	private static final int PRODUCT_NAME_INDEX = 0;
	private static final int PRODUCT_PRICE_INDEX = 1;
	private static final int PRODUCT_COUNT_INDEX = 2;

	private final List<Product> products;

	public VendingMachineProducts(List<String> vendingMachineProducts) {
		this.products = makeProducts(vendingMachineProducts);
	}

	private List<Product> makeProducts(List<String> vendingMachineProducts) {
		return vendingMachineProducts.stream()
			.map(this::makeProduct)
			.collect(Collectors.toList());
	}

	private Product makeProduct(String vendingMachineProduct) {
		List<String> productInformation = Arrays.stream(vendingMachineProduct.split(COMMA))
			.collect(Collectors.toList());
		return new Product(productInformation.get(PRODUCT_NAME_INDEX),
			Integer.parseInt(productInformation.get(PRODUCT_PRICE_INDEX)),
			Integer.parseInt(productInformation.get(PRODUCT_COUNT_INDEX)));
	}
}
