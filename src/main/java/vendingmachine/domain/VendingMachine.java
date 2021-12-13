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
		if (isBuy(productName)) {
			Product product = products.findForName(productName);
			product.buy();
			insertMoney = insertMoney.subtract(product.getPrice());
		}
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
		if (product == null) {
			return false;
		}
		if (product.soldOut()) {
			return false;
		}
		if (!product.isBuy(insertMoney)) {
			return false;
		}
		return true;
	}

	public Money getInsertMoney() {
		return insertMoney;
	}
}
