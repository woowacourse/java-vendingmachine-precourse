package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.views.InputView;
import vendingmachine.views.OutputView;

public class VendingMachineController {
	private final VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		insertChanges();
		vendingMachine.printCoins();
		insertItems();
		insertMoney();
		do {
			purchase();
		} while(true);
	}

	private void insertChanges() {
		try {
			String changesString = InputView.inputChanges();
			vendingMachine.insertChanges(new Money(changesString));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			insertChanges();
		}
	}

	private void insertItems() {
		try {
			String itemsString = InputView.inputItems();
			vendingMachine.insertItems(itemsString);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			insertItems();
		}
	}

	private void insertMoney() {
		try {
			String moneyString = InputView.inputMoney();
			vendingMachine.insertMoney(moneyString);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			insertMoney();
		}
	}

	private void purchase() {
		try {
			vendingMachine.printMoney();
			String itemName = InputView.inputItemName();
			vendingMachine.purchase(itemName);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			purchase();
		}
	}
}
