package vendingmachine.domain;

public class Menu {
	private String name;
	private int price;
	private int count;

	public Menu(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Menu from(String menuInfo) {
		return null;
	}
}
