package vendingmachine.domain;

public class VendingMachine {

	private int enteredAmount;

	public VendingMachine(int enteredAmount) {
		this.enteredAmount = enteredAmount;
	}

	public int getEnteredAmount() {
		return this.enteredAmount;
	}

	public boolean isBuy(int lowestPossibleProductPrice) {
		return this.enteredAmount >= lowestPossibleProductPrice;
	}

	public void buy(int spendMoney) {
		this.enteredAmount -= spendMoney;
	}
}
