package vendingmachine.Model;

import vendingmachine.Utils.Validator.MoneyValidator;

public class Money {
	private int money;

	public Money(String money) {
		validate(money);
		this.money = Converter.getInt(money);
	}

	public Money(int money) {
		validate(Integer.toString(money));
		this.money = money;
	}

	public int get() {
		return money;
	}

	public void set(int money) {
		this.money = money;
	}

	public void setMinus(int money) {
		this.money -= money;
	}

	public boolean isEmpty() {
		return money == 0;
	}

	public boolean isBiggerOrSame(int money) {
		return this.money >= money;
	}

	public void validate(String money) {
		try {
			new MoneyValidator(money);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
