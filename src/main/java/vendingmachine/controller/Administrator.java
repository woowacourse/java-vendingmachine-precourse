package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;

import static vendingmachine.view.Input.*;

public class Administrator {
	private VendingMachine vendingMachine;

	public Administrator(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public String getMoneyOfChanges() {
		return inputMoneyOfChanges();
	}

	public String getProducts() {
		return inputProducts(vendingMachine);
	}
}
