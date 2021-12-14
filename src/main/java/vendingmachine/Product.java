package vendingmachine;

public class Product {
	private String name;
	private int price;
	private int quantity;

	Product(String name, int price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPrice(){
		return this.price;
	}

	public int getQuantity(){
		return this.quantity;
	}
}
