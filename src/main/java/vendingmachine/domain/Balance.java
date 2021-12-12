package vendingmachine.domain;

public class Balance {
	private int balance;

	public Balance(int balance) {
		this.balance = balance;
	}

	public void reduceBalance(int price) {
		balance -= price;
	}

	public boolean canBuy(int price) {
		return balance >= price;
	}

	public int getBalance() {
		return balance;
	}
}
