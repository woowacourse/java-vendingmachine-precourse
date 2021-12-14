package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;

public class Controller {
	public void runMachine() {
		//메인로직 시작
		VendingMachine vendingMachine = VendingMachine.getInstance();
		vendingMachine.init();

	}
}
