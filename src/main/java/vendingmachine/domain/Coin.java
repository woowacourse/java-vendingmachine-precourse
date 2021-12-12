package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

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

	public int getRemainingNumber() {
		return remainingNumber;
	}

	@Override
	public String toString() {
		return amount + "원" + " - " + numberOfCoin + "개";
	}

	public String toStringRemainingNumber() {
		return amount + "원" + " - " + remainingNumber + "개";
	}
}
