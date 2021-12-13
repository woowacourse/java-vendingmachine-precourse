package vendingmachine.model;

public class Product {
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

	//상품이 주문된 후 재고 감소
	public void sold() {
		--quantity;
	}
}
