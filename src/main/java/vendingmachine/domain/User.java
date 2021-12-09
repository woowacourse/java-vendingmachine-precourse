package vendingmachine.domain;

public class User {
	private int money;

	public User(int money) {
		this.money = money;
	}

	public void buyProduct(int price) {
		money -= price;
	}

	public boolean isEnoughMoney(int price) {
		return money - price >= 0;
	}
}
