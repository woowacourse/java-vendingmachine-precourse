package vendingmachine.model;

import vendingmachine.constant.Message;

public class VendingMachine {

	private HoldingSum holdingSum;
	private Stock stock;
	private InsertingSum insertingSum;

	public VendingMachine() {
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
		checkRestInsertingSum(name);
		Product soldProduct = stock.giveProduct(name);
		insertingSum.subtract(soldProduct.getPrice());
	}

	private void checkRestInsertingSum(Name name) {
		Product selectedProduct = stock.getProduct(name);

		if (insertingSum.isLessThan(selectedProduct.getPrice())) {
			throw new IllegalArgumentException(Message.ERROR_INSERTING_SUM_IS_LESS_PRICE);
		}

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

	public Change getChange() {
		Change change = new Change(insertingSum, holdingSum);
		insertingSum.subtract(change.sum());
		holdingSum.subtractChange(change);
		return change;
	}
}
