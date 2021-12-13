package vendingmachine;

public class VendingMachine {
	private int leftMoney;
	private int numberOfCoin_500;
	private int numberOfCoin_100;
	private int numberOfCoin_50;
	private int numberOfCoin_10;
	private Product[] products;

	VendingMachine(){
		this.leftMoney = InputReceiver.getNumber();
	}
}
