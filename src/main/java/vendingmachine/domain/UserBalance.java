package vendingmachine.domain;

public class UserBalance {
	private int userBalance;

	public UserBalance(int userBalance) {
		this.userBalance = userBalance;
	}

	public void deductMoney(int deductValue) {
		this.userBalance -= deductValue;
	}

	public int getUserBalance() {
		return this.userBalance;
	}
}
