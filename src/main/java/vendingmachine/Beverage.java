package vendingmachine;

public class Beverage {
	String name;
	int price;
	int count;

	public Beverage(String readString) {
		String[] beverageInfo = Validater.beveragesValid(readString);
		this.name = beverageInfo[0];
		this.price = Integer.parseInt(beverageInfo[1]);
		this.count = Integer.parseInt(beverageInfo[2]);
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
		this.count -=1 ;
	}
	

}
