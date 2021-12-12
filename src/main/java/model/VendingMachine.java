package model;

public class VendingMachine {
	private VendingMachineCoinBox vendingMachineCoinBox;

	public void makeVendingMachineCoinBox(int inputVendingMachineChange) {
		vendingMachineCoinBox = new VendingMachineCoinBox(inputVendingMachineChange);
	}
}
