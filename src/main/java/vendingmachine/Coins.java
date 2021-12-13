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
}
