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
		insertMoney.plus(money);
	}

	public int compareCheapestPrice(Money money) {
		products.removeSoldOutProduct();
		Money cheapestPrice = products.getCheapestPrice();
		return money.compareTo(cheapestPrice);
	}
}
