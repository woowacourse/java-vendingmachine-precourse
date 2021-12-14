package vendingmachine;

public class Beverage {
	final static int INDEX_NAME = 0;
	final static int INDEX_PRICE = 1;
	final static int INDEX_COUNT = 2;
	String name;
	int price;
	int count;

	public Beverage(String readString) {
		String[] beverageInfo = Validater.beveragesValid(readString);
		this.name = beverageInfo[INDEX_NAME];
		this.price = Integer.parseInt(beverageInfo[INDEX_PRICE]);
		this.count = Integer.parseInt(beverageInfo[INDEX_COUNT]);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

	public void sellBeverage() {
		this.count -= 1;
	}

}
