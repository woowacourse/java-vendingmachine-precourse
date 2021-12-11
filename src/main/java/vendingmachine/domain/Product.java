package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.List;

public class Product {
	public static int INDEX_OF_PRODUCT_NAME = 0;
	public static int INDEX_OF_PRODUCT_PRICE = 1;
	public static int INDEX_OF_PRODUCT_QUANTITY = 2;
	public static final int ZERO_PRODUCT_QUANTITY = 0;

	private String name;
	private int price;
	private int quantity;

	public Product(List<String> productToString) {
		this.name = productToString.get(INDEX_OF_PRODUCT_NAME);
		this.price = Integer.parseInt(productToString.get(INDEX_OF_PRODUCT_PRICE));
		this.quantity = Integer.parseInt(productToString.get(INDEX_OF_PRODUCT_QUANTITY));
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public int getChangePrice(int inputAmount) {
		if (!isPurchaseProduct(inputAmount)) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "남은 투입 금액 부족으로 구매할 수 없습니다.");
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
