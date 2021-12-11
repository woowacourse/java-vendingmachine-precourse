package vendingmachine.domain;

import vendingmachine.constant.Coin;

public class Deposit implements Comparable<Deposit> {

	private final Coin coin;
	private int count;

	public Deposit(Coin coin) {
		this.coin = coin;
	}

	public Deposit(Coin coin, int count) {
		this.coin = coin;
		this.count = count;
	}

	public Coin getCoin() {
		return coin;
	}

	public int getCount() {
		return count;
	}

	public void decreaseBy(int count) {
		this.count -= count;
	}

	@Override
	public int compareTo(Deposit o) {
		if (coin.getAmount() == o.getCoin().getAmount())
			return count - o.getCount();
		return coin.getAmount() - o.getCoin().getAmount();
	}
}
