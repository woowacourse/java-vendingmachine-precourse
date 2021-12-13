package vendingmachine.controller;

import vendingmachine.model.User;
import vendingmachine.model.VendingMachine;

public class VendingMachineController {

	VendingMachine vendingMachine;
	User user;

	public VendingMachineController(VendingMachine vendingMachine, User user) {
		this.vendingMachine = vendingMachine;
		this.user = user;
	}

	public void run() {
		while (vendingMachine.isRemainProduct() && vendingMachine.canBuy(user)) {

		}
	}
}
