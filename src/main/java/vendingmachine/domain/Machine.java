package vendingmachine.domain;

import vendingmachine.Coin;

public class Machine {
	private final int money;
	private Coins coins;

	public Machine(int money) {
		this.money = money;
		this.coins = new Coins();
	}

	public void makeCoins() {
		coins.makeCoins(money);
	}

	public void printCoins() {
		System.out.println(coins.toString());
	}
}
