package vendingmachine.domain;

public class Product implements Comparable<Product>{
	private String name;
	private int price;
	private int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	/**** getter ****/
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	/**** action ****/
	public void sellProduct() {
		stock --;
	}

	@Override
	public int compareTo(Product o) {
		return Integer.compare(this.price, o.price);
	}

}
