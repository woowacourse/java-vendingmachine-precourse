package model;

import java.util.List;

public class VendingMachine {
	private VendingMachineCoinBox vendingMachineCoinBox;
	private VendingMachineProducts vendingMachineProducts;

	public void makeVendingMachineCoinBox(int insertVendingMachineChange) {
		vendingMachineCoinBox = new VendingMachineCoinBox(insertVendingMachineChange);
	}

	public void makeVendingMachineProducts(List<String> vendingMachineProductsInformation) {
		vendingMachineProducts = new VendingMachineProducts(vendingMachineProductsInformation);
	}

	public List<Integer> giveEachCoinCount() {
		return vendingMachineCoinBox.bringEachCoinCountInCoinBox();
	}

	public List<Integer> giveEachCoinPrice() {
		return vendingMachineCoinBox.bringEachCoinPriceInCoinBox();
	}
}
