package vendingmachine;

import java.util.stream.Stream;

public class Coins extends Remaining<Coin>{
	Coins() {
		Stream<Coin> coinStream = Stream.of(Coin.values());
		coinStream.forEach(coin -> this.put(coin,0));
	}

	public int getSum() {
		Stream<Coin> coinStream = Stream.of(Coin.values());
		int sum = coinStream
			.map(coin -> this.get(coin))
			.reduce(0,Integer::sum);

		return sum;
	}

	private int changeSum;

	public void returnChange(int changeSum) {
		this.changeSum = changeSum;
	}

	public void addOne(int amount) {
		Coin thisCoin = findByAmount(amount);
		put(thisCoin, get(thisCoin)+1);
	}

	public static Coin findByAmount(int amount) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == amount) {
				return coin;
			}
		}
		throw new IllegalArgumentException("[ERROR] 올바른 동전이 아닙니다.");
	}
}
