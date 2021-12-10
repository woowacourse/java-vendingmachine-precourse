package vendingmachine.controller;

import vendingmachine.model.Coin;
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

		order();
		printResult();
	}

	public void order() {

		while (!vendingMachine.stopMachine()) {
			vendingMachineView.printRemainOfInsertedMoney(vendingMachine.getRemainMoney());
			userView.orderMenu();
			vendingMachine.takeOrder();
		}

	}

	public void printResult() {
		vendingMachineView.printChangesComment(vendingMachine.getRemainMoney());

		for (Coin coin : Coin.values()) {
			vendingMachineView.printChanges(vendingMachine.giveChanges(coin), coin);
		}

	}
	
}
