package vendingmachine.model;

public class Vendingmachine {

	HoldingSum holdingSum;

	public Vendingmachine() {
		holdingSum = new HoldingSum();
	}

	public HoldingSum getHoldingSum() {
		return holdingSum;
	}

	public void setHoldingSum(HoldingSum holdingSum) {
		this.holdingSum = holdingSum;
	}
}
