package vendingmachine.domain;

public class Item {
	private String name;
	private int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void decreaseQuantity() {
		if (!isPurchasable()) {
			throw new IllegalArgumentException("[ERROR] 상품이 소진되었습니다. 다른 상품을 선택해주세요.");
		}
		this.quantity -= 1;
	}

	private boolean isPurchasable() {
		return this.quantity > 0;
	}
}
