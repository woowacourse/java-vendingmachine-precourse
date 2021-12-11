package vendingmachine.product;

import vendingmachine.money.Money;
import vendingmachine.payments.Payments;

public class Product {
	private static final String ERROR_NAME_DUPLICATE = "상품명은 중복될 수 없습니다.";
	private static final int NONE = 0;

	private String name;
	private Integer price;
	private Integer quantity;

	public Product(String name, Integer price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void isDuplicate(Product product) {
		if (this.name.equals(product.name)) {
			throw new IllegalArgumentException(ERROR_NAME_DUPLICATE);
		}
	}

	public boolean isSameName(String name) {
		if (this.name.equals(name)) {
			return true;
		}
		return false;
	}

	public boolean isEnoughMoney(Money money) {
		if (money.isEnough(price)) {
			return true;
		}
		return false;
	}

	public boolean isRemainStock() {
		if (quantity == NONE) {
			return false;
		}
		return true;
	}

	public void buyWith(Payments payments) {
		quantity--;
		payments.pay(price);
	}
}
