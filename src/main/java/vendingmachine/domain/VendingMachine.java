package vendingmachine.domain;

public class VendingMachine {
	private Coins coins;
	private Products products;
	private int inputMoney;

	public VendingMachine (Coins coins, Products products, int inputMoney){
		this.coins = coins;
		this.products = products;
		this.inputMoney = inputMoney;
	}
}
