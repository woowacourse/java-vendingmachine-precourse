package vendingmachine.controller;

import static vendingmachine.view.Input.*;

import vendingmachine.domain.VendingMachine;

public class Consumer {
	private VendingMachine vendingMachine;

	public Consumer(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public String getMoney() {
		return inputMoney();
	}

	public String selectProduct() {
		return inputSelectedProduct();
	}
}
