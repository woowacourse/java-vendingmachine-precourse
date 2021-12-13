package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	public boolean hasAnyProduct() {
		return products.stream().filter(product -> !product.isSoldOut()).count() > 0;
	}

	public int bringMinimumProductPrice() {
		Comparator<Product> comparatorByPrice = Comparator.comparingInt(Product::bringPrice);
		return products.stream().max(comparatorByPrice).orElseThrow(NoSuchElementException::new).bringPrice();
	}

	public int sellProduct(String productName) {
		Product soldProduct = products.stream()
			.filter(product -> product.isSameName(productName))
			.collect(Collectors.toList())
			.get(0);
		return soldProduct.reduceCount();
	}
}
