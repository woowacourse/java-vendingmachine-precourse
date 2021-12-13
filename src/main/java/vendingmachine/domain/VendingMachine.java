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
		System.out.println(product);
		if (product == null || insertMoney.compareTo(product.getPrice()) < 0) {
			return;
		}
		product.buy();
		insertMoney = insertMoney.subtract(product.getPrice());
	}


	public boolean isBuy() {
		if (products.soldOut()) {
			return false;
		}
		if (!products.isBuy(insertMoney)) {
			return false;
		}
		return true;
	}

	public boolean isBuy(String productName) {
		Product product = products.findForName(productName);
		if (product == null || product.soldOut() || !product.isBuy(insertMoney)) {
			return false;
		}
		return true;
	}

	public Money getInsertMoney() {
		return insertMoney;
	}
}
