package vendingmachine.model;

public class InputMoney {

	private int money = 0;

	public InputMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public boolean isBiggerThanPrice(int price) {
		return this.money >= price;
	}

}
