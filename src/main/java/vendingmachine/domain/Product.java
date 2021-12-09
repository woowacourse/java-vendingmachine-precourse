package vendingmachine.domain;

public class Product implements Comparable<Product>{

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
		return this.price-o.getPrice();
	}

	public void subtractAmount(){
		amount--;
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
