package vendingmachine.app;

import vendingmachine.model.VendingMachine;
import vendingmachine.service.VendingMachineService;

public class ObjectContainer {
	private static final VendingMachine vendingMachine = new VendingMachine();

	public static VendingMachineService getVendingMachineService() {
		return new VendingMachineService(vendingMachine);
	}
}

