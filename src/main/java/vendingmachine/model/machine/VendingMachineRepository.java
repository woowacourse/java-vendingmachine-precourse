package vendingmachine.model.machine;

public class VendingMachineRepository {
	private static VendingMachine vendingMachine = null;

	public static VendingMachine save(VendingMachine machine) {
		vendingMachine = machine;
		return vendingMachine;
	}

	public static VendingMachine find() {
		return vendingMachine;
	}
}
