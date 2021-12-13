package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Change {

	Wallet wallet;
	int remainBalance;
	Map<Coin, Integer> change = new LinkedHashMap<>();

	public Change(Wallet wallet, int remainBalance) {
		this.wallet = wallet;
		this.remainBalance = remainBalance;
		Coin[] coins = Coin.values();
		Arrays.stream(coins).forEach(coin -> change.put(coin, 0));
	}

	public Map<Coin, Integer> calculateChange() {
		while (true) {
			Coin coin = wallet.canReturn(remainBalance);
			if (remainBalance == 0 || coin == null)
				break;
			wallet.reduceCoin(coin);
			change.put(coin, change.get(coin) + 1);
			remainBalance -= coin.getAmount();
		}
		return change;
	}
}
