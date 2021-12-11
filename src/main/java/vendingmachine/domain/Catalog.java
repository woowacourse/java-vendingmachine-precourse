package vendingmachine.domain;

public class Catalog {
	private String name;
	private int price;
	private int amount;

	public Catalog(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public void print() {
		System.out.println("상품명: " + name);
		System.out.println("가격: " + price);
		System.out.println("수량: " + amount);
	}
}
