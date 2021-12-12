package vendingmachine;

public class Beverage {
	String name;
	int price;
	int count;
	
	public Beverage(String name, int price, int count) {
		this.name =name;
		this.price = price;
		this.count = count;
	}
	public String getName(){
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
}
