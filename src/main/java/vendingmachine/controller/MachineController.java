package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;

public class MachineController {
	public void work() {
		VendingMachine vendingMachine = new VendingMachine();
		InputController inputController = new InputController();
		vendingMachine.holdingMoney = inputController.scanHoldingMoney();
		vendingMachine.coinCount = RandomCoinMaker.makeRandomCoin(vendingMachine.holdingMoney);
		System.out.println(vendingMachine.coinCount);
	}
}
