package vendingmachine.domain;

public class VendingMachine {
	private int currentAmount;

	public VendingMachine(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void deduct(int productPrice) {
		currentAmount -= productPrice;
	}
}
