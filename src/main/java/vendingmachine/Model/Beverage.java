package vendingmachine.Model;

public class Beverage {
	public final String name;
	public final Money price;
	private int stock;

	public Beverage(Object[] values) {
		name = (String)values[0];
		price = new Money((int)values[1]);
		this.stock = (int)values[2];
	}

	public void sell() {
		stock--;
	}

	public boolean isSoldOut() {
		return stock == 0;
	}
}
