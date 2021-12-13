package vendingmachine.controller;

import vendingmachine.model.User;
import vendingmachine.model.VendingMachine;

public class VendingMachineController {

	private final VendingMachine vendingMachine;
	private final User user;

	public VendingMachineController(VendingMachine vendingMachine, User user) {
		this.vendingMachine = vendingMachine;
		this.user = user;
	}

	public void run() {
		while (vendingMachine.isRemainProduct() && vendingMachine.canBuy(user)) {
			user.printRemain();
			vendingMachine.buyProduct(user);
		}
		user.printRemain();
		vendingMachine.getChange(user);
	}
}
