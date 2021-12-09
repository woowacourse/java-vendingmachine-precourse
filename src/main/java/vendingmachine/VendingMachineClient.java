package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class VendingMachineClient {

	private VendingMachineController vendingMachineController = new VendingMachineController();

	public void start(){
		vendingMachineController.postVendingMachineCosts();
		vendingMachineController.postProductInfo();
		vendingMachineController.postInputCosts();
		vendingMachineController.postProductName();
		vendingMachineController.getBalance();
	}
}
