package vendingmachine.controller;

import static vendingmachine.view.Input.*;

import vendingmachine.domain.VendingMachine;

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
