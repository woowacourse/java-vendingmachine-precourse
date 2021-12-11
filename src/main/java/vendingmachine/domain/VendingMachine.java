package vendingmachine.domain;

public class VendingMachine {
	private Money changes;

	public void inputChanges(Money changes) {
		this.changes = changes;
	}
}
