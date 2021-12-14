package vendingmachine.model;

public class UserMoney {
	private int money;

	public UserMoney(int money) {
		this.money = money;
	}

	public void subtract(int price) {
		if (money >= price) {
			this.money -= price;
		}
	}

	public int getMoney() {
		return this.money;
	}

	public boolean canNotBuy(int minPrice) {
		return this.money < minPrice;
	}

	public int getNumOfChange(int amount) {
		return this.money / amount;
	}
}
