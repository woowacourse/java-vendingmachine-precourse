package vendingmachine.domain;

import java.util.List;
import java.util.Objects;

public class Product {
	private String name;
	private int price;
	private int amount;

	public Product(List<String> productInfo) {
		this.name = productInfo.get(ProductIdx.NAME.ordinal());
		this.price = Integer.parseInt(productInfo.get(ProductIdx.PRICE.ordinal()));
		this.amount = Integer.parseInt(productInfo.get(ProductIdx.AMOUNT.ordinal()));
	}

	public boolean isSameName(String name) {
		return name.equals(this.name);
	}

	public int getSmallerPrice(int price) {
		return Math.min(this.price, price);
	}

	public int minusPrice(int money) {
		return money - price;
	}

	public boolean isInStock() {
		return amount > 0;
	}

	public void decreaseAmount() {
		amount--;
	}

	public int addAmount(int totalAmount) {
		return totalAmount + amount;
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

	private enum ProductIdx {NAME, PRICE, AMOUNT}
}
