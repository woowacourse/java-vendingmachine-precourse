package vendingmachine.domain.coin;

import java.util.Comparator;

public class CoinMapComparator implements Comparator<Coin> {
	@Override
	public int compare(Coin o1, Coin o2) {
		int coinAmount1 = o1.getAmount();
		int coinAmount2 = o2.getAmount();
		return -(coinAmount1 - coinAmount2);
	}
}
