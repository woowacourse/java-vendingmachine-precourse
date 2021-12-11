package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineAccount {
	private static final Map<Coin, Integer> coinCount = new HashMap<>();
	private static int account;

	public VendingMachineAccount() {
	}

	public void addCoinCount(Coin coin, Integer amount) {
		coinCount.put(coin, amount);
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public Integer getCoinCount(Coin coin) {
		return coinCount.get(coin);
	}

	public void printCoinCount() {

	}
}
