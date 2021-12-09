package vendingmachine.model.machine;

public class VendingMachineRepository {
	private VendingMachine vendingMachine;

	public void save(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public VendingMachine find() {
		return vendingMachine;
	}
}
