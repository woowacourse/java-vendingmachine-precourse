package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private VendingMachine vendingMachine;

	public VendingMachineController() {
		callNewVendingMachineWithException();
	}

	private void callNewVendingMachineWithException() {
		try {
			callNewVendingMachine();
		} catch (Exception e) {
			logError(e);
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
		} catch (Exception e) {
			logError(e);
			addItemsWithException();
		}
	}

	private void addItems() {
		OutputView.addItems();
		vendingMachine.addNewItems(InputView.readItems());
		OutputView.breakLine();
	}

	public void buyItemsWithException() {
		OutputView.enterInputMoney();
		int money = InputView.readPositiveInt();
		try {
			buyItems(money);
		} catch (Exception e) {
			logError(e);
			checkSoldOutAndBuyItemsWithException();
		}
	}

	private void checkSoldOutAndBuyItemsWithException() {
		if (!vendingMachine.isAnySalesItem()) {
			OutputView.soldOutEveryItems();
			return;
		}
		buyItemsWithException();
	}

	private void buyItems(int money) {
		while (checkCanBuyProduct(money)) {
			OutputView.showRemainingMoney(money);
			OutputView.enterWantProduct();
			String product = InputView.readLineString();
			money = vendingMachine.getItem(product, money);
			OutputView.breakLine();
		}
	}

	public void showVendingMachineCoins() {
		OutputView.showCoinStorageState(vendingMachine.getCoinStorageBox());
	}

	private boolean checkCanBuyProduct(int money) {
		return money >= vendingMachine.getNeedMinimumMoney();
	}

	private void logError(Exception error) {
		System.out.println(error.getMessage());
		OutputView.breakLine();
	}
}