package vendingmachine.product;

import vendingmachine.billing.Money;

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
		return this.name.equals(name);
	}

	public boolean isEnoughMoney(Money money) {
		return money.isEnough(price);
	}

	public boolean isRemainStock() {
		return quantity != NONE;
	}

	public int release() {
		quantity--;
		return price;
	}
}
