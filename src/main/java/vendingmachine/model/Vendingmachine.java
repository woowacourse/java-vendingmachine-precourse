package vendingmachine.model;

public class Vendingmachine {

	private HoldingSum holdingSum;
	private Stock stock;
	private InsertingSum insertingSum;

	public Vendingmachine() {
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

	public void sellProduct(Name name) {
		Product soldProduct = stock.giveProduct(name);
		insertingSum.subtractPrice(soldProduct.getPrice());
	}

	public boolean isPossibleToSell() {

		if (stock.isEmpty()) {
			return false;
		}

		if (insertingSum.isLessThan(stock.getMinPrice())) {
			return false;
		}

		return true;
	}
}
