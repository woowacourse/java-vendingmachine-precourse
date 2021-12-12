package vendingmachine.domain;

public class VendingMachine {
	private final Changes changes;

	public VendingMachine(int money) {
		changes = new Changes(money);
	}

	public Changes getChanges() {
		return changes;
	}
}
