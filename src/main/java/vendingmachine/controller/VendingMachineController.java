package vendingmachine.controller;

import vendingmachine.constants.ErrorMessage;
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
		setInitCoins();
		printInitCoins();

		userView.askProductsInfo();
		vendingMachine.setMenu();

		userView.askInsertMoney();
		vendingMachine.insertMoney();

		order();
		printChanges();
	}

	public void setInitCoins() {
		userView.askInitCoins();

		while (true) {
			try {
				vendingMachine.setCoins(userView.insertInitCoins());
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorMessage.ERROR + e.getMessage());
			}
			break;
		}

	}

	public void printInitCoins() {
		vendingMachineView.printInitCoinsComment();

		for (Coin coin : Coin.values()) {
			vendingMachineView.printCoin(vendingMachine.countCoin(coin), coin);
		}
	}

	public void setMenuList() {
		userView.askProductsInfo();

		while (true) {
			try {
				vendingMachine.setMenu(userView.insertProductsInfo());
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorMessage.ERROR + e.getMessage());
			}
			break;
		}

	}

	public void order() {

		while (!vendingMachine.stopMachine()) {
			vendingMachineView.printRemainOfInsertedMoney(vendingMachine.getRemainMoney());
			userView.orderMenu();
			vendingMachine.takeOrder();
		}

	}

	public void printChanges() {
		vendingMachineView.printChangesComment(vendingMachine.getRemainMoney());

		for (Coin coin : Coin.values()) {
			int changes = vendingMachine.giveChanges(coin);

			if (changes != 0) {
				vendingMachineView.printCoin(changes, coin);
			}

		}

	}

}
