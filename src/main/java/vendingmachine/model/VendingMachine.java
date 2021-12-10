package vendingmachine.model;

public class VendingMachine {
	private int insertedMoney;
	private Changes changes;

	public VendingMachine() {
		insertedMoney = 0;
		changes = new Changes();
	}

	public void setCoins() {
		changes.setCoinList();
	}

	public int countCoin(int idx) {
		return changes.countCoin(idx);
	}
}
