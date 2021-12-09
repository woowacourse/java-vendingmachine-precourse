package vendingmachine.domain;


public class Product {
	private String name;
	private int price;
	private int amount;

	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getPrice(){
		return price;
	}

	public int getAmount(){
		return amount;
	}

	public void sellProduct(){
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
