package vendingmachine.domain;

import vendingmachine.view.messages.Message;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private int numberOfCoin;
	private int remainingNumber;

	Coin(final int amount) {
		this.amount = amount;
		this.numberOfCoin = 0;
		this.remainingNumber = 0;
	}

	// 추가 기능 구현

	public static Coin getCoinByAmount(int amount) {
		if (amount == COIN_500.getAmount()) {
			return COIN_500;
		}
		if (amount == COIN_100.getAmount()) {
			return COIN_100;
		}
		if (amount == COIN_50.getAmount()) {
			return COIN_50;
		}
		return COIN_10;
	}

	public boolean isNotZeroRemainingNumber() {
		return remainingNumber > 0;
	}

	public void addCoin() {
		this.numberOfCoin += 1;
	}

	public void addRemainingNumber() {
		this.remainingNumber += 1;
	}

	public void reduceCoin() {
		this.numberOfCoin -= 1;
	}

	public int getAmount() {
		return this.amount;
	}

	public int getNumberOfCoin() {
		return numberOfCoin;
	}

	@Override
	public String toString() {
		return amount + Message.MONEY_UNIT + Message.COIN_DELIMITER + numberOfCoin + Message.COUNT_UNIT;
	}

	public String toStringRemainingNumber() {
		return amount + Message.MONEY_UNIT + Message.COIN_DELIMITER + remainingNumber + Message.COUNT_UNIT;
	}
}
