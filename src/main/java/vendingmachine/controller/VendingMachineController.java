package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachine vendingMachine;
	private int money;

	public VendingMachineController() {
		callNewVendingMachine();
	}

	private void callNewVendingMachine() {
		try {
			tryToCallNewVendingMachine();
		} catch (Exception error) {
			logError(error);
			callNewVendingMachine();
		}
	}

	private void tryToCallNewVendingMachine() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readPositiveInt());
		OutputView.showCoins(vendingMachine.getCoinStorageBox());
	}

	public void addItems() {
		try {
			tryToAddItems();
		} catch (Exception error) {
			logError(error);
			addItems();
		}
	}

	private void tryToAddItems() {
		OutputView.addItems();
		vendingMachine.addNewItems(InputView.readItems());
		OutputView.breakLine();
	}

	public void putMoney() {
		OutputView.enterInputMoney();
		money = InputView.readPositiveInt();
	}

	public void buyItems() {
		try {
			tryToBuyItems();
		} catch (Exception error) {
			logError(error);
			buyItems();
		}
	}

	private void tryToBuyItems() {
		while (canBuyItem()) {
			OutputView.showRemainingMoney(money);
			OutputView.enterWantProduct();
			String product = InputView.readLineString();
			money = vendingMachine.getItem(product, money);
			OutputView.breakLine();
		}
	}

	private boolean canBuyItem() {
		return isEnoughMoney() && isAnySalesItem();
	}

	private boolean isEnoughMoney() {
		return money >= vendingMachine.getNeedMinimumMoney();
	}

	private boolean isAnySalesItem() {
		return vendingMachine.isAnySalesItem();
	}

	public void getMoney() {
		OutputView.showCoinStorageState(vendingMachine.getCoinStorageBox());
	}

	private void logError(Exception error) {
		System.out.println(error.getMessage());
		OutputView.breakLine();
	}
}