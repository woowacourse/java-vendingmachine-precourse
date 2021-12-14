package vendingmachine.repository;

import static java.lang.Math.*;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class VendingMachineAccount {
	private static final Map<Coin, Integer> coinCount = new HashMap<>();
	private static int account;

	public VendingMachineAccount() {
		for (Coin coin : Coin.values()) {
			coinCount.put(coin, 0);
		}
	}

	public static Map<Coin, Integer> getAllCoinCount() {
		return coinCount;
	}

	public static int getPossibleCoinCount(Coin coin, int maxCoinCount) {
		int remainingCoinCount = coinCount.get(coin);
		return min(remainingCoinCount, maxCoinCount);
	}

	public void addCoinCount(Coin coin) {
		coinCount.put(coin, coinCount.get(coin) + 1);
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
}
