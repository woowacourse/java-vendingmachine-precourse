package vendingmachine.domain;

public class Item {
	public String name;
	public int price;
	public int count;

	public Item(String[] itemInform) {
		this.name = itemInform[0];
		this.price = Integer.parseInt(itemInform[1]);
		this.count = Integer.parseInt(itemInform[2]);
	}
	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}
}
