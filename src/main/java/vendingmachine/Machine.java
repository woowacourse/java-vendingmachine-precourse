package vendingmachine;

public enum Machine {
	MACHINE;

	private int amount;

	public void insertCoinToMachine(int amount){
		this.amount = amount;
	}

	public int getMachineAmount(){
		return amount;
	}

	public void changeMachineAmount(int productPrice){
		amount -= productPrice;
	}
}
