package vendingmachine.domain;

import static vendingmachine.utils.ExceptionMessage.*;
import static vendingmachine.utils.ProductValidator.*;

import java.util.List;

public class Product {
	public static int INDEX_OF_PRODUCT_NAME = 0;
	public static int INDEX_OF_PRODUCT_PRICE = 1;
	public static int INDEX_OF_PRODUCT_QUANTITY = 2;
	public static final int ZERO_PRODUCT_QUANTITY = 0;
	private final String name;
	private final int price;
	private int quantity;

	public Product(List<String> productToString) {
		validateProductPrice(Integer.parseInt(productToString.get(INDEX_OF_PRODUCT_PRICE)));
		this.name = productToString.get(INDEX_OF_PRODUCT_NAME);
		this.price = Integer.parseInt(productToString.get(INDEX_OF_PRODUCT_PRICE));
		this.quantity = Integer.parseInt(productToString.get(INDEX_OF_PRODUCT_QUANTITY));
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public int getChangePrice(int inputAmount) {
		if (!isPurchaseProduct(inputAmount)) {
			throw new IllegalArgumentException(ERROR_INSUFFICIENT_INPUT_AMOUNT);
		}
		minusOneForQuantity();
		return inputAmount - this.price;
	}

	public boolean isNotOutOfQuantity() {
		return this.quantity > ZERO_PRODUCT_QUANTITY;
	}

	private void minusOneForQuantity() {
		quantity--;
	}

	public boolean isPurchaseProduct(int inputAmount) {
		return price <= inputAmount;
	}
}
