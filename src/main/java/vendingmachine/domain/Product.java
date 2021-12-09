package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.List;

public class Product {
	private String name;
	private int price;
	private int quantity;

	public Product(List<String> productToString) {
		this.name = productToString.get(0);
		this.price = Integer.parseInt(productToString.get(1));
		this.quantity = Integer.parseInt(productToString.get(2));
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
		return this.quantity > 0;
	}

	private void minusOneForQuantity() {
		quantity--;
	}

	public boolean isPurchaseProduct(int inputAmount) {
		return price <= inputAmount;
	}
}
