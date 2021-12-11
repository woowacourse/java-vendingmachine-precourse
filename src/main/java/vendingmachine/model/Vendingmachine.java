package vendingmachine.model;

public class Vendingmachine {

	private HoldingSum holdingSum;
	private Stock stock;
	private InsertingSum insertingSum;

	public Vendingmachine() {
		holdingSum = new HoldingSum();
		stock = new Stock();
		insertingSum = new InsertingSum();
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

	public InsertingSum getInsertingSum() {
		return insertingSum;
	}

	public void setInsertingSum(InsertingSum insertingSum) {
		this.insertingSum = insertingSum;
	}
}
