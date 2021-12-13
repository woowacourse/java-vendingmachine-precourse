package vendingmachine.domain;

public class VendingMachine {
	private final Coins coins;
	private final Products products;
	private final int inputMoney;

	public VendingMachine (Coins coins, Products products, int inputMoney){
		this.coins = coins;
		this.products = products;
		this.inputMoney = inputMoney;
	}

	public boolean checkTermination() {
		if (products.isLessThanMinPrice(inputMoney)){
			return true;
		}
		if (products.getTotalAmount() == 0) {
			return true;
		}
		return false;
	}
}
