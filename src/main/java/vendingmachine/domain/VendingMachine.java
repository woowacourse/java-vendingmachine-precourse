package vendingmachine.domain;

public class VendingMachine {
	private Changes changes;
	private Products products;
	private Money insertMoney = new Money(0);

	public VendingMachine(Changes changes, Products products) {
		this.changes = changes;
		this.products = products;
	}

	public void insertMoney(Money money) {
		insertMoney = money;
	}

	public boolean compareCheapestPrice(Money money) {
		Money cheapestPrice = products.getCheapestPrice();
		if (money.compareTo(cheapestPrice) < 0) {
			return false;
		}
		return true;
	}
}
