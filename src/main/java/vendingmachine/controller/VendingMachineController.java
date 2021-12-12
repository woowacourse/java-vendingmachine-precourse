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

		insertMoney();

		repeatOrder();
		printChanges();
	}

	public void setInitCoins() {
		boolean successInitCoins = false;
		vendingMachineView.askInitCoins();

		while (!successInitCoins) {
			successInitCoins = setInitCoinsIfItIsRight();
		}

	}

	public boolean setInitCoinsIfItIsRight() {
		try {
			vendingMachine.setCoins(userView.insertInitCoins());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

	public void printInitCoins() {
		vendingMachineView.printInitCoinsComment();

		for (Coin coin : Coin.values()) {
			vendingMachineView.printCoin(vendingMachine.countCoin(coin), coin);
		}
	}

	public void setMenuList() {
		boolean successSetMenuList = false;
		vendingMachineView.askProductsInfo();

		while (!successSetMenuList) {
			successSetMenuList = setMenuListIfItIsRight();
		}

	}

	public boolean setMenuListIfItIsRight() {
		try {
			vendingMachine.setMenu(userView.insertProductsInfo());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

	public void insertMoney() {
		boolean successInsertMoney = false;
		vendingMachineView.askInsertMoney();

		while (!successInsertMoney) {
			successInsertMoney = insertMoneyIfItIsRight();
		}

	}

	public boolean insertMoneyIfItIsRight() {
		try {
			vendingMachine.insertMoney(userView.insertMoney());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
	}

	public void repeatOrder() {

		while (!vendingMachine.stopMachine()) {
			vendingMachineView.printRemainOfInsertedMoney(vendingMachine.getRemainMoney());
			order();
		}

	}

	public void order() {
		boolean successOrder = false;
		vendingMachineView.askOrderMenu();

		while (!successOrder) {
			successOrder = orderIfIsRight();
		}

	}

	public boolean orderIfIsRight() {
		try {
			vendingMachine.takeOrder(userView.OrderMenu());
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return false;
		}
		return true;
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
