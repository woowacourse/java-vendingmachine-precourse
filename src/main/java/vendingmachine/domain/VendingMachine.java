package vendingmachine.domain;

public class VendingMachine {

	private int enteredAmount;

	public VendingMachine(int enteredAmount) {
		this.enteredAmount = enteredAmount;
	}

	public int getEnteredAmount() {
		return this.enteredAmount;
	}
	
	public boolean isBuy(Products products) {
		return products.isBuy(enteredAmount);
	}

	public void buy(int spendMoney) {
		this.enteredAmount -= spendMoney;
	}
}
