package model.products;

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
	private static final String HAS_DUPLICATE_PRODUCT_NAME_ERROR_MESSAGE = "[ERROR] 입력한 자판기 상품 중 상품명이 중복 되는 상품이 있다.";
	private static final String NOT_HAS_PRODUCT_NAME_ERROR_MESSAGE = "[ERROR] 입력한 구매 상품명이 상품 목록에 없다.";
	private static final String NOT_HAS_ENOUGH_MONEY_ERROR_MESSAGE = "[ERROR] 입력한 구매 상품명을 살 돈이 부족하다.";

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
			throw new IllegalArgumentException(HAS_DUPLICATE_PRODUCT_NAME_ERROR_MESSAGE);
		}
		return true;
	}

	private String bringProductName(String product) {
		return Arrays.stream(product.split(COMMA)).collect(Collectors.toList()).get(PRODUCT_NAME_INDEX);
	}

	private Product makeProduct(String product) {
		List<String> productInformation = Arrays.stream(product.split(COMMA)).collect(Collectors.toList());
		return new Product(productInformation.get(PRODUCT_NAME_INDEX),
			Integer.parseInt(productInformation.get(PRODUCT_PRICE_INDEX)),
			Integer.parseInt(productInformation.get(PRODUCT_COUNT_INDEX)));
	}

	public boolean hasProduct() {
		return productBox.stream().anyMatch(product -> !product.isSoldOut());
	}

	public int getMinimumProductPrice() {
		List<Product> productsInStock = productBox.stream()
			.filter(product -> !product.isSoldOut())
			.collect(Collectors.toList());
		Comparator<Product> comparatorByPrice = Comparator.comparingInt(Product::getPrice);
		return productsInStock.stream().min(comparatorByPrice).orElseThrow(NoSuchElementException::new).getPrice();
	}

	public void sellProduct(String productName, int insertedMoney) {
		if (hasProductNameToSellInProductBox(productName) && hasEnoughMoneyToBuySameNameProduct(productName,
			insertedMoney)) {
			findProductToSell(productName).reduceStock();
			return;
		}
		throw new IllegalArgumentException();
	}

	private boolean hasProductNameToSellInProductBox(String productName) {
		if (productBox.stream().noneMatch(product -> product.hasSameName(productName))) {
			throw new IllegalArgumentException(NOT_HAS_PRODUCT_NAME_ERROR_MESSAGE);
		}
		return true;
	}

	private boolean hasEnoughMoneyToBuySameNameProduct(String productName, int insertedMoney) {
		int productPriceToSell = findProductToSell(productName).getPrice();
		if (productPriceToSell > insertedMoney) {
			throw new IllegalArgumentException(NOT_HAS_ENOUGH_MONEY_ERROR_MESSAGE);
		}
		return true;
	}

	public int giveSoldProductPrice(String productName) {
		return findProductToSell(productName).getPrice();
	}

	private Product findProductToSell(String productName) {
		return productBox.stream()
			.filter(product -> product.hasSameName(productName))
			.collect(Collectors.toList())
			.get(PRODUCT_NAME_INDEX);
	}

}
