package vendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.view.Print.*;

public class VendingMachineManagement {
	private VendingMachine vendingMachine;
	private VendingMachineController controller;

	public static final String SPLIT_PRODUCTS = ";";
	public static final String COVER_PRODUCT_START = "[";
	public static final String COVER_PRODUCT_START_PATTERN = "^\\" + COVER_PRODUCT_START;
	public static final String COVER_PRODUCT_END = "]";
	public static final String COVER_PRODUCT_END_PATTERN = COVER_PRODUCT_END + "$";
	public static final String EMPTY = "";
	public static final String SPLIT_PRODUCT = ",";
	public static final String SPLIT_PRODUCT_PATTERN = ".*" + SPLIT_PRODUCT + ".*" + SPLIT_PRODUCT + ".*";

	public static final String PRODUCT_NAME = "name";
	public static final int PRODUCT_NAME_INDEX = 0;
	public static final String PRODUCT_PRICE = "price";
	public static final int PRODUCT_PRICE_INDEX = 1;
	public static final String PRODUCT_QUANTITY = "quantity";
	public static final int PRODUCT_QUANTITY_INDEX = 2;

	public VendingMachineManagement(VendingMachine vendingMachine, VendingMachineController controller) {
		this.vendingMachine = vendingMachine;
		this.controller = controller;
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

			productsFormMap.add(getProductFormMap(product));
		}
		return productsFormMap;
	}

	private HashMap<String, String> getProductFormMap(String[] product) {
		HashMap<String, String> productFormMap = new HashMap<>();

		productFormMap.put(PRODUCT_NAME, product[PRODUCT_NAME_INDEX]);
		productFormMap.put(PRODUCT_PRICE, product[PRODUCT_PRICE_INDEX]);
		productFormMap.put(PRODUCT_QUANTITY, product[PRODUCT_QUANTITY_INDEX]);

		return productFormMap;
	}

	public static String[] splitStringOfProducts(String stringOfProducts) {
		return stringOfProducts.split(SPLIT_PRODUCTS);
	}

	public static String removeTextCoverProduct(String product) {
		product = product.replaceFirst(COVER_PRODUCT_START_PATTERN, EMPTY);
		product = product.replaceAll(COVER_PRODUCT_END_PATTERN, EMPTY);

		return product;
	}

	public static String[] splitStringOfProduct(String stringOfProduct) {
		String[] product = stringOfProduct.split(SPLIT_PRODUCT, -1);

		for (int i = 0; i < product.length; i++) {
			product[i] = product[i].trim();
		}
		return product;
	}

	public void noticeInsertMoney() {
		printInsertMoney();
	}

	public void insertMoney(String stringOfMoney) {
		int money = Integer.parseInt(stringOfMoney);
		vendingMachine.setMoney(money);

		purchase(money);
		returnChanges();
	}

	private void purchase(int money) {
		noticeRemainMoney(money);

		if (vendingMachine.isPurchase()) {
			String product = selectProduct();
			vendingMachine.buy(product);

			purchase(vendingMachine.getMoney());
		}
	}

	private void noticeRemainMoney(int money) {
		printRemainMoney(money);
	}

	private String selectProduct() {
		noticeSelectProduct();

		return controller.selectProduct();
	}

	private void noticeSelectProduct() {
		printSelectProduct();
	}

	private void returnChanges() {
		vendingMachine.returnChanges();
	}
}
