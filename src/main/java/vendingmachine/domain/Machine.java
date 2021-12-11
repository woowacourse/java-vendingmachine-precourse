package vendingmachine.domain;

public class Machine {
	private int userMoney;

	public Machine() {
		this.userMoney = 0;
	}

	public Machine(int userMoney) {
		this.userMoney = userMoney;
	}

	public int getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}

	public void decreaseUserMoney(int amount) {
		this.userMoney -= amount;
	}
}
