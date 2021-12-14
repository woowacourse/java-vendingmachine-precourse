package vendingmachine;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private int count = 0;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public int getValue() {
		return amount;
	}

	public void addCount(int addCount) {
		count += addCount;
	}

	public int getCount() {
		return count;
	}

	public void subCount(int subCount) {
		count -= subCount;
	}

	public int toChange(UserMoney userMoney) {
		int coinCount = 0;
		if (count > 0) {
			coinCount = Math.min(count, userMoney.getNumOfChange(amount));
		}
		userMoney.subtract(coinCount * amount);
		subCount(coinCount);
		return coinCount;
	}

	public boolean sameValue(int coinValue) {
		return amount == coinValue;
	}
}
