package model;

import java.util.List;

public class VendingMachine {
	private VendingMachineCoinBox vendingMachineCoinBox;

	public void makeVendingMachineCoinBox(int insertVendingMachineChange) {
		vendingMachineCoinBox = new VendingMachineCoinBox(insertVendingMachineChange);
	}

	public List<Integer> giveEachCoinCount() {
		return vendingMachineCoinBox.bringEachCoinCountInCoinBox();
	}

	public List<Integer> giveEachCoinValue() {
		return vendingMachineCoinBox.bringEachCoinValueInCoinBox();
	}
}
