package vendingmachine.domain;

import vendingmachine.util.Symbol;

public class Item {
	private String name;
	private int price;
	private int quantity;

	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemInfo(){
		StringBuilder builder = new StringBuilder();
		builder.append(name + Symbol.SPACE).append(price + Symbol.SPACE).append(quantity + Symbol.MEW_LINE);
		return builder.toString();
	}
}
