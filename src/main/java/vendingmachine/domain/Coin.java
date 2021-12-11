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
}
