package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

public enum Coin {
	COIN_500(500, 0),
	COIN_100(100, 0),
	COIN_50(50, 0),
	COIN_10(10, 0);

	private final int amount;
	private int count;

	Coin(final int amount, int count) {
		this.amount = amount;
		this.count = count;
	}

	public void increaseCount() {
		count++;
	}

	@Override
	public String toString() {
		return amount + KOR_MONETARY_UNIT + DASH_WITH_SPACE + count + KOR_ITEM_UNIT;
	}
}
