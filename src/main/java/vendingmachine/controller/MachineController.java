package vendingmachine.controller;

import vendingmachine.domain.Machine;
import vendingmachine.view.InputView;

public class MachineController {
	private InputView inputView = new InputView();

	public void run() {
		int machineMoney = inputView.enterMachineMoney();
		Machine machine = new Machine(machineMoney);
		machine.makeCoins();
		machine.printCoins();
		inputView.enterItems();
	}
}
