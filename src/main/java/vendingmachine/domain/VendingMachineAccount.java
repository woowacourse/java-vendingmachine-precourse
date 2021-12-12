package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineAccount {
	private static final Map<Coin, Integer> coinCount = new HashMap<>();
	private static int account;

	public void addCoinCount(Coin coin, Integer amount) {
		coinCount.put(coin, amount);
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public static Integer getCoinCountByCoin(Coin coin) {
		return coinCount.get(coin);
	}

	public static Map<Coin, Integer> getAllCoinCount() {
		return coinCount;
	}
}
