package vendingmachine.service;

import static vendingmachine.view.Print.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vendingmachine.domain.VendingMachine;

public class VendingMachineManagement {
	private VendingMachine vendingMachine;

	public static final String SPLIT_PRODUCTS = ";";
	public static final String COVER_PRODUCT_START = "[";
	public static final String COVER_PRODUCT_END = "]";
	public static final String EMPTY = "";
	public static final String SPLIT_PRODUCT = ",";
	public static final int PRODUCT_INFO_COUNT = 3;

	public static final String PRODUCT_NAME = "name";
	public static final int PRODUCT_NAME_INDEX = 0;
	public static final String PRODUCT_PRICE = "price";
	public static final int PRODUCT_PRICE_INDEX = 1;
	public static final String PRODUCT_QUANTITY = "quantity";
	public static final int PRODUCT_QUANTITY_INDEX = 2;

	public VendingMachineManagement(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void noticeInsertMoneyOfChanges() {
		printInsertMoneyOfChanges();
	}

	public void insertMoneyOfChanges(int money) {
		vendingMachine.setChanges(money);
	}

	public void noticeCountOfCoins() {
		printCountOfCoinsTitle();
		vendingMachine.noticeCountOfCoins();
	}

	public void noticeInsertProducts() {
		printInsertProducts();
	}

	public void insertProducts(String products) {
		List<HashMap<String, String>> productsFormMap = getProductsFormMap(products);
		vendingMachine.setProducts(productsFormMap);
	}

	private List<HashMap<String, String>> getProductsFormMap(String stringOfProducts) {
		String[] products = splitStringOfProducts(stringOfProducts);
		List<HashMap<String, String>> productsFormMap = new ArrayList<>(products.length);

		for (String stringOfProduct : products) {
			stringOfProduct = removeTextCoverProduct(stringOfProduct);
			String[] product = splitStringOfProduct(stringOfProduct);
			HashMap<String, String> productFormMap = new HashMap<>();
			productFormMap.put(PRODUCT_NAME, product[PRODUCT_NAME_INDEX]);
			productFormMap.put(PRODUCT_PRICE, product[PRODUCT_PRICE_INDEX]);
			productFormMap.put(PRODUCT_QUANTITY, product[PRODUCT_QUANTITY_INDEX]);
			productsFormMap.add(productFormMap);
		}
		return productsFormMap;
	}

	public static String[] splitStringOfProducts(String stringOfProducts) {
		return stringOfProducts.split(SPLIT_PRODUCTS);
	}

	public static String removeTextCoverProduct(String product) {
		product = product.replace(COVER_PRODUCT_START, EMPTY);
		product = product.replace(COVER_PRODUCT_END, EMPTY);

		return product;
	}

	public static String[] splitStringOfProduct(String stringOfProduct) {
		String[] product = stringOfProduct.split(SPLIT_PRODUCT);

		for (int i = 0; i < product.length; i++) {
			product[i] = product[i].trim();
		}
		return product;
	}

	// 자판기 거래 관련

	// 투입 금액 검증

	// 구매할 수 있는 상황인지 확인

	// 구매하는 상품 정보 검증

	// 구매하는 상품 이름 자판기에 전달

	// 잔돈 반환
}
