package vendingmachine.domain;

public class VendingMachine {
	private Changes changes;
	private Products products;

	public VendingMachine(Changes changes, Products products) {
		this.changes = changes;
		this.products = products;
	}
}
