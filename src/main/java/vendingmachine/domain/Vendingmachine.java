package vendingmachine.domain;

public class Vendingmachine {

	HoldingSum holdingSum;

	public Vendingmachine() {
		holdingSum = new HoldingSum();
	}

	public void setHoldingSum(HoldingSum holdingSum) {
		this.holdingSum = holdingSum;
	}
}
