package vendingmachine.domain;

public class Product {
	private Name name;
	private Money price;
	private Quantity quantity;

	public Product(Name name, Money price, Quantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product{" +
			"name=" + name +
			", price=" + price +
			", quantity=" + quantity +
			'}';
	}

	public boolean isSameName(Name name) {
		String productName = this.name.get();
		String checkProductName = name.get();
		return productName.equals(checkProductName);
	}
}
