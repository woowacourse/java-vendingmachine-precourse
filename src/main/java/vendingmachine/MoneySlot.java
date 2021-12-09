package vendingmachine;

public class MoneySlot {
	private int money;

	public void insert(String money) {
		this.money = Integer.parseInt(money);
	}
}
