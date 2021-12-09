package vendingmachine.domain;

import java.util.Map;

public class VendingMachineAccount {
	private static Map<Coin, Integer> coinCount;

	public static void setRandomCoins(int amount) {
		System.out.println("vending machine account = " + amount);
	}
}
