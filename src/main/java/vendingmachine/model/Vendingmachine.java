package vendingmachine.model;

public class Vendingmachine {

	HoldingSum holdingSum;
	Stock stock;

	public Vendingmachine() {
		holdingSum = new HoldingSum();
		stock = new Stock();
	}

	public HoldingSum getHoldingSum() {
		return holdingSum;
	}

	public void setHoldingSum(HoldingSum holdingSum) {
		this.holdingSum = holdingSum;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
