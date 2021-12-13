package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.view.InputView;
import vendingmachine.ValidatorVendingMachine;

public class Products {
	private static final int PRODUCT_NAME_INDEX = 0;
	private static final int PRODUCT_PRICE_INDEX = 1;
	private static final int PRODUCT_AMOUNT_INDEX = 2;
	private static final String ERROR_PRODUCT_DUPLICATE = "[ERROR] 중복된 상품이 있습니다.";
	private static final String ERROR_PRODUCT_IS_NOT_EXIST = "[ERROR] 해당 상품이 없습니다.";

	private List<Product> productList = new ArrayList<>();

	Products() {
	}

	public void addProduct() {
		String[] eachProductInput = InputView.setVendingMachineProducts();
		for (String s : eachProductInput) {
			Product product = createProduct(s);
			isProductDuplicate(product);
			productList.add(product);
		}
	}

	public void removeProduct(Product product) {
		productList.remove(product);
	}

	public Product createProduct(String eachProduct) {
		String[] productInput = ValidatorVendingMachine.validateMachineProduct(eachProduct);
		int price = Integer.parseInt(productInput[PRODUCT_PRICE_INDEX]);
		int amount = Integer.parseInt(productInput[PRODUCT_AMOUNT_INDEX]);
		return new Product(productInput[PRODUCT_NAME_INDEX], price, amount);
	}

	public Product getProductByName(String productName) {
		return productList.stream()
			.filter(product -> product.getProductName().equals(productName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_PRODUCT_IS_NOT_EXIST));
	}

	public int getMinProductPrice() {
		return productList.stream()
			.mapToInt(Product::getPrice).min()
			.orElse(0);
	}

	public void isProductDuplicate(Product product) {
		if (productList.contains(product)) {
			throw new IllegalArgumentException(ERROR_PRODUCT_DUPLICATE);
		}
	}
}
