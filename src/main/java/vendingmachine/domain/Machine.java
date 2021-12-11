package vendingmachine.domain;

public class Machine {
	private int amount;

	public void save(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void changeAmount(int productPrice){
		amount -= productPrice;
	}

	public boolean isAmountLessThanMinOfProductsPrice(int minOfProductsPrice) {
		return amount < minOfProductsPrice;
	}
}
