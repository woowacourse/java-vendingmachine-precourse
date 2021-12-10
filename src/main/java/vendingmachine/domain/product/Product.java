package vendingmachine.domain.product;

public class Product {
	private final String name;
	private final int price;
	private int amount;

	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
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

	public boolean isExistedProduct(){
		return amount > 0;
	}
	public void sellProduct() {
			amount--;
	}

	@Override
	public String toString() {
		return "Product{" +
			"name='" + name + '\'' +
			", price=" + price +
			", amount=" + amount +
			'}';
	}
}
