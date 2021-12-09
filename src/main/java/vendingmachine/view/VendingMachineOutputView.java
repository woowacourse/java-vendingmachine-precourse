package vendingmachine.view;

import static vendingmachine.constants.HostMessages.*;

public class VendingMachineOutputView {
	private static final VendingMachineOutputView vendingMachineOutputView = new VendingMachineOutputView();

	private VendingMachineOutputView() {
	}

	public static VendingMachineOutputView getVendingMachineOutputView(){
		return vendingMachineOutputView;
	}

	public void printAmountInputMessage(){
		System.out.println(VENDING_MACHINE_INITIAL_MONEY_INPUT_MESSAGE);
	}
}
