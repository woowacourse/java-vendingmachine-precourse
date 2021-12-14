package vendingmachine.billing;

public class Money {
	private static final int ZERO = 0;

	private int amount;

	public Money(String money) {
		this.amount = Integer.parseInt(money);
	}

	public boolean isLeft() {
		return amount > ZERO;
	}

	public boolean isChangeable(int coinValue) {
		return amount >= coinValue;
	}

	public void change(int coinValue) {
		amount -= coinValue;
	}

	public void pay(int productValue) {
		amount -= productValue;
	}

	public boolean isEnough(int productValue) {
		return amount >= productValue;
	}

	public String toString() {
		return String.valueOf(amount);
	}
}
