package vendingmachine.domain;

import java.util.Objects;

public class Product implements Comparable<Product> {

	private String name;
	private int price;
	private int amount;

	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	@Override
	public int compareTo(Product o) {
		return this.price - o.getPrice();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public void subtractAmount() {
		if (amount > 0) {
			amount--;
		}
	}

	public boolean CanInputCostSubtract(int inputCost) {
		if (inputCost - price >= 0) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}
}
