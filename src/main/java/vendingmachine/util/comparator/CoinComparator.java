package vendingmachine.util.comparator;

import java.util.Comparator;

import vendingmachine.domain.Coin;

public class CoinComparator implements Comparator<Coin> {
	@Override
	public int compare(Coin c1, Coin c2) {
		return Integer.compare(c1.getAmount(), c2.getAmount());
	}
}
