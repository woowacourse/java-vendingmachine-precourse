package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		processMachineMoney();
		processBeverage();
	}

	private void processMachineMoney() {
		int machineMoney = InputView.getMachineMoney();
		Coin.generateRandomCount(machineMoney);
		OutputView.printMachineCoins();
	}

	private void processBeverage() {
		List<Item> items = InputView.getItems();
		for (Item item : items) {
			System.out.println("item = " + item);
		}
	}
}
