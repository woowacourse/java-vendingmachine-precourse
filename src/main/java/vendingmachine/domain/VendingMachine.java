package vendingmachine.domain;

public class VendingMachine {
	private Changes changes;
	private Products products;
	private Money remainingMoney = new Money(0);

	public VendingMachine(Changes changes, Products products) {
		this.changes = changes;
		this.products = products;
	}

	public void deposit(Money money) {
		this.remainingMoney = this.remainingMoney.plus(money);
	}

	public void withdraw(Money money) {
		if (remainingMoney.compareTo(money) < 0) {
			return;
		}
		remainingMoney = remainingMoney.subtract(money);
	}

	public void buy(String productName) {
		Product product = products.findForName(productName);
		if (product == null || remainingMoney.compareTo(product.getPrice()) < 0) {
			return;
		}
		product.buy();
		withdraw(product.getPrice());
	}

	public boolean isBuy() {
		Product product = products.getCheapestProduct();
		return product != null &&
			remainingMoney.compareTo(product.getPrice()) >= 0;
	}

	public boolean isBuy(String productName) {
		Product product = products.findForName(productName);
		return product != null &&
			product.isBuy(remainingMoney);
	}

	public Changes returnChanges() {
		Changes changes = this.changes.toChangesMinCount(remainingMoney);
		withdraw(changes.getTotalMoney());
		return changes;
	}

	public Money getRemainingMoney() {
		return remainingMoney;
	}
}
