package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.UserView;
import vendingmachine.view.VendingMachineView;

public class VendingMachineController {
	public VendingMachine vendingMachine;
	public VendingMachineView vendingMachineView;
	public UserView userView;

	public VendingMachineController() {
		vendingMachine = new VendingMachine();
		vendingMachineView = new VendingMachineView();
		userView = new UserView();
	}

	public void use() {
		userView.askVendingMachineCoins();
		vendingMachine.setCoins();
		vendingMachineView.printCoinsOfVendingMachine(vendingMachine);

		userView.askProductsInfo();
		vendingMachine.setMenu();

		userView.askInsertMoney();
		vendingMachine.insertMoney();

		while (true) {
			userView.printRemainOfInsertedMoney(vendingMachine.getRemainMoney());
			userView.orderMenu();
			vendingMachine.takeOrder();
		}

	}
}
