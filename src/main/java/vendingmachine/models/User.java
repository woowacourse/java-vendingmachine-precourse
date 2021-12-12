package vendingmachine.models;

public class User {
	private int payMoney = 0;

	public User(int payMoney) {
		this.payMoney = payMoney;
	}

	public void decreasePayMoney(int value) {
		this.payMoney -= value;
	}
}
