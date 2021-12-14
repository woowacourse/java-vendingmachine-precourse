package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;

import static vendingmachine.view.Input.*;

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
