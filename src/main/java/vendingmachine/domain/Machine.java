package vendingmachine.domain;

public enum Machine {
	MACHINE;

	private int amount;

	public void insertCoinToMachine(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void changeAmount(int productPrice){
		amount -= productPrice;
	}
}
