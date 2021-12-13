package vendingmachine;

import utils.validator.IsAmount;

public class Amount {
	private int amount;

	public Amount(int amount) {
		String amountStr = Integer.toString(amount);
		StringBuilder amountSB = new StringBuilder(amountStr);
		new IsAmount().run(amountSB);

		this.amount = amount;
	}

	public int get() {
		return amount;
	}
}
