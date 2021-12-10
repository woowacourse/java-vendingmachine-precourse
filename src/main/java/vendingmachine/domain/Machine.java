package vendingmachine.domain;

public enum Machine {
	MACHINE;

	private int amount;

	public void insertCoin(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void changeAmount(int productPrice){
		amount -= productPrice;
	}

	public boolean isAmountLessThanProductMinPrice(int minPrice) {
		return amount < minPrice;
	}
}
