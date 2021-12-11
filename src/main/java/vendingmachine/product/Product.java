package vendingmachine.product;

public class Product {
	private static final String ERROR_NAME_DUPLICATE = "상품명은 중복될 수 없습니다.";
	private static final String ERROR_NOT_LEFT = "해당 상품의 재고가 부족하여 구매할 수 없습니다.";
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

	public boolean isPurchasable(int money) {
		if (isEnoughMoney(money) && isRemainStock()) {
			return true;
		}
		return false;
	}

	private boolean isEnoughMoney(int money) {
		if (price > money) {
			return false;
		}
		return true;
	}

	private boolean isRemainStock() {
		if (quantity == NONE) {
			return false;
		}
		return true;
	}

	public int sell() {
		validateOutOfStock();
		quantity--;
		return price;
	}

	private void validateOutOfStock() {
		if (quantity == NONE) {
			throw new IllegalArgumentException(ERROR_NOT_LEFT);
		}
	}
}
