package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductBox {
	private static final String COMMA = ",";
	private static final int PRODUCT_NAME_INDEX = 0;
	private static final int PRODUCT_PRICE_INDEX = 1;
	private static final int PRODUCT_COUNT_INDEX = 2;

	private final List<Product> productBox;

	public ProductBox(List<String> products) {
		this.productBox = makeBox(products);
	}

	private List<Product> makeBox(List<String> products) {
		if (hasNoDuplicateProduct(products)) {
			return products.stream()
				.map(this::makeProduct)
				.collect(Collectors.toList());
		}
		throw new IllegalArgumentException();
	}

	private boolean hasNoDuplicateProduct(List<String> products) {
		List<String> productNames = products.stream()
			.map(this::bringProductName)
			.collect(Collectors.toList());
		int distinctProductCount = (int)productNames.stream().distinct().count();
		if (distinctProductCount != products.size()) {
			throw new IllegalArgumentException("[ERROR] 입력한 자판기 상품 중 상품명이 중복 되는 상품이 있다.");
		}
		return true;
	}

	private String bringProductName(String product) {
		return Arrays.stream(product.split(COMMA)).collect(Collectors.toList()).get(0);
	}

	private Product makeProduct(String product) {
		List<String> productInformation = Arrays.stream(product.split(COMMA)).collect(Collectors.toList());
		return new Product(productInformation.get(PRODUCT_NAME_INDEX),
			Integer.parseInt(productInformation.get(PRODUCT_PRICE_INDEX)),
			Integer.parseInt(productInformation.get(PRODUCT_COUNT_INDEX)));
	}

	public boolean hasProduct() {
		return productBox.stream().filter(product -> !product.isSoldOut()).count() > 0;
	}

	public int getMinimumProductPrice() {
		Comparator<Product> comparatorByPrice = Comparator.comparingInt(Product::getPrice);
		return productBox.stream().max(comparatorByPrice).orElseThrow(NoSuchElementException::new).getPrice();
	}

	public void sellProduct(String productName) {
		if (hasProductToSellInProductBox(productName)) {
			findSoldProduct(productName).reduceCount();
			return;
		}
		throw new IllegalArgumentException();
	}

	private boolean hasProductToSellInProductBox(String productName) {
		if (productBox.stream().noneMatch(product -> product.isSameName(productName))) {
			throw new IllegalArgumentException("[ERROR] 입력한 구매 상품명이 상품 목록에 없다.");
		}
		return true;
	}

	public int giveSoldProductPrice(String productName) {
		return findSoldProduct(productName).getPrice();
	}

	private Product findSoldProduct(String productName) {
		return productBox.stream()
			.filter(product -> product.isSameName(productName))
			.collect(Collectors.toList())
			.get(0);
	}

}
