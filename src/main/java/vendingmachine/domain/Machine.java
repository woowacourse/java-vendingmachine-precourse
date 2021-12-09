package vendingmachine.domain;

public class Machine {
	private final int money;
	private Coins coins;

	public Machine(int money) {
		this.money = money;
		this.coins = new Coins();
	}

	public void makeCoins() {
		coins.makeCoins(money);
		if (coins == null) {
			System.out.println("1");
		}
	}

	public void printCoins() {
		System.out.println(coins.toString());
	}
}
