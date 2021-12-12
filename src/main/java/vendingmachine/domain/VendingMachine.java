package vendingmachine.domain;

public class VendingMachine {

	private final int enteredAmount;

	public VendingMachine(int enteredAmount) {
		this.enteredAmount = enteredAmount;
	}

	public int getEnteredAmount() {
		return this.enteredAmount;
	}
	
	public boolean isBuy(int lowestPossibleProductPrice) {
		return this.enteredAmount >= lowestPossibleProductPrice;
	}
}
