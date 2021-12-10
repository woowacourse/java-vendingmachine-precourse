package vendingmachine.model.machine;

public class VendingMachineRepository {
	private static VendingMachine vendingMachine = null;

	public static void save(VendingMachine machine) {
		vendingMachine = machine;
	}

	public static VendingMachine find() {
		return vendingMachine;
	}
}
