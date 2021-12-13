package vendingmachine.view;

import vendingmachine.domain.Coins;

public class Output {
	public static void coinsInMachine(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		System.out.println(coins);
	}
}
