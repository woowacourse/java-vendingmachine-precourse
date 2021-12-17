package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachine vendingMachine;
	private int money;

	public VendingMachineController() {
		callNewVendingMachineWithException();
	}

	private void callNewVendingMachineWithException() {
		try {
			callNewVendingMachine();
		} catch (Exception error) {
			logError(error);
			callNewVendingMachineWithException();
		}
	}

	private void callNewVendingMachine() {
		OutputView.setVendingMachineMoney();
		vendingMachine = new VendingMachine(InputView.readPositiveInt());
		OutputView.showCoins(vendingMachine.getCoinStorageBox());
	}

	public void addItemsWithException() {
		try {
			addItems();
		} catch (Exception error) {
			logError(error);
			addItemsWithException();
		}
	}

	private void addItems() {
		OutputView.addItems();
		vendingMachine.addNewItems(InputView.readItems());
		OutputView.breakLine();
	}

	public void putMoney() {
		OutputView.enterInputMoney();
		money = InputView.readPositiveInt();
	}

	public void buyItemsWithException() {
		try {
			buyItems();
		} catch (Exception error) {
			logError(error);
			buyItemsWithException();
		}
	}

	private void buyItems() {
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

	public void showVendingMachineCoins() {
		OutputView.showCoinStorageState(vendingMachine.getCoinStorageBox());
	}

	private void logError(Exception error) {
		System.out.println(error.getMessage());
		OutputView.breakLine();
	}
}