package model;

public class VendingMachine {
	private VendingMachineCoinBox vendingMachineCoinBox;

	public void makeVendingMachineCoinBox(int insertVendingMachineChange) {
		vendingMachineCoinBox = new VendingMachineCoinBox(insertVendingMachineChange);
	}
}
