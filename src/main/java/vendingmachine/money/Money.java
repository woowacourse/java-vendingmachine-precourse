package vendingmachine.money;

public class Money {
	private static final int ZERO = 0;

	private int amount;

	public Money(String money, String prefix) {
		MoneyValidator moneyValidator = new MoneyValidator();
		moneyValidator.validate(money, prefix);
		this.amount = Integer.parseInt(money);
	}

	public boolean isLeft() {
		if (amount > ZERO) {
			return true;
		}
		return false;
	}

	public boolean isChangeable(int coinValue) {
		if (amount >= coinValue) {
			return true;
		}
		return false;
	}

	public void change(int coinValue) {
		amount -= coinValue;
	}

	public void pay(int productValue) {
		amount -= productValue;
	}

	public boolean isNotEnough(int productValue) {
		if (amount < productValue) {
			return true;
		}
		return false;
	}

	public boolean isEnough(int productValue) {
		if (amount >= productValue) {
			return true;
		}
		return false;
	}

	public String toString() {
		return String.valueOf(amount);
	}
}
