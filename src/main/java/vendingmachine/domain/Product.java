package vendingmachine.domain;

public class Product {
	private final String name;
	private final int price;
	private final int cnt;

	public Product(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public Product reduce(int amount) {
		//예외처리 필요
		return new Product(this.name, this.price, this.cnt - amount);
	}

	public boolean isSameOrHigherPrice(int price) {
		return price >= this.price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCnt() {
		return cnt;
	}
}
