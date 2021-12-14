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

	public void buy(String productName) {
		Product product = products.findForName(productName);
		if (product == null || insertMoney.compareTo(product.getPrice()) < 0) {
			return;
		}
		product.buy();
		insertMoney = insertMoney.subtract(product.getPrice());
	}

	public boolean isBuy() {
		Product product = products.getCheapestProduct();
		return product != null &&
			insertMoney.compareTo(product.getPrice()) >= 0;
	}

	public boolean isBuy(String productName) {
		Product product = products.findForName(productName);
		return product != null &&
			!product.soldOut() &&
			product.isBuy(insertMoney);
	}

	public Changes returnChanges() {
		return changes.toChangesMinCount(insertMoney);
	}

	public Money getInsertMoney() {
		return insertMoney;
	}
}
