package vendingmachine.controller;

import vendingmachine.view.VendingMachineInputView;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();
	private final VendingMachineInputView vendingMachineInputView;
	private final VendingMachineOutputView vendingMachineOutputView;

	private VendingMachineController() {
		vendingMachineInputView = VendingMachineInputView.getVendingMachineInputView();
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
	}

	public static VendingMachineController getVendingMachineController(){
		return vendingMachineController;
	}

	public void run(){
		vendingMachineOutputView.printAmountInputMessage();
		int amount = vendingMachineInputView.getInitialAmount();
	}
}
