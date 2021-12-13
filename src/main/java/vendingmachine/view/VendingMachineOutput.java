package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.models.VendingMachine;
import vendingmachine.utils.VendingMachineMessage;

public class VendingMachineOutput {

	private VendingMachine vendingMachine;

	public VendingMachineOutput(final VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void printCoinTypesAmount() {
		HashMap<Integer, Integer> coinTypesAmount = vendingMachine.getCoinTypesAmount();
		VendingMachineMessage.printCoinTypesAmount(coinTypesAmount);
	}
}
