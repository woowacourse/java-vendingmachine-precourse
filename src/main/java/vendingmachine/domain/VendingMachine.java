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
		insertMoney = insertMoney.plus(money);
	}

	public boolean isBuy() {
		products.removeSoldOutProduct();
		Money cheapestPrice = products.getCheapestPrice();
		return insertMoney.compareTo(cheapestPrice) >= 0;
	}
}
