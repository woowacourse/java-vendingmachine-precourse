package vendingmachine;

import utils.validator.isAmount;

public class Amount {
	private int amount;

	Amount(int amount) {
		String amountStr = Integer.toString(amount);
		StringBuilder amountSB = new StringBuilder(amountStr);
		new isAmount().run(amountSB);
		this.amount = amount;
	}

	public int get() {
		return amount;
	}
}
