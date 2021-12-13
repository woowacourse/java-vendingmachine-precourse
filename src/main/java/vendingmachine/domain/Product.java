package vendingmachine.domain;

public class Product {

	private static final String ERROR_SOLD_OUT_PRODUCT = "상품의 재고가 모두 소진되었습니다.";
	private static final String ERROR_NOT_ENOUGH_MONEY = "금액이 부족합니다.";
	private static final int ZERO = 0;

	private String name;
	private int price;
	private int quantity;

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void validatePossibleToPurchase(Product product, int userMoney) {
		if (product.getQuantity() == ZERO) {
			throw new IllegalArgumentException(ERROR_SOLD_OUT_PRODUCT);
		}
		if (product.getPrice() > userMoney) {
			throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
		}
	}

	public void reduceQuantity() {
		quantity--;
	}
}
