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

		setMenuList();

		insetMoney();

		repeatOrder();
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

	public void insetMoney() {
		userView.askInsertMoney();

		while (true) {
			try {
				vendingMachine.insertMoney(userView.insertMoney());
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorMessage.ERROR + e.getMessage());
			}
			break;
		}

	}

	public void repeatOrder() {

		while (!vendingMachine.stopMachine()) {
			vendingMachineView.printRemainOfInsertedMoney(vendingMachine.getRemainMoney());
			order();
		}

	}

	public void order() {
		userView.askOrderMenu();

		while (true) {
			try {
				vendingMachine.takeOrder(userView.OrderMenu());
			} catch (IllegalArgumentException e) {
				System.out.println(ErrorMessage.ERROR + e.getMessage());
			}
			break;
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
