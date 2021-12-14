package vendingmachine.domain;

public class VendingMachine {
	private static final VendingMachine vendingMachine = new VendingMachine();

	private VendingMachine() {
	}

	public static VendingMachine getInstance() {
		return vendingMachine;
	}

	public void init() {
	}

}
