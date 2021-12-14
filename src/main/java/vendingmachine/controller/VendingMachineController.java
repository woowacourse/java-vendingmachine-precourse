package vendingmachine.controller;

import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.repository.ItemRepository;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		processMachineMoney();
		processBeverage();
		processBuying();
	}

	private void processMachineMoney() {
		int machineMoney = InputView.getMachineMoney();
		Coin.generateRandomCount(machineMoney);
		OutputView.printMachineCoins();
	}

	private void processBeverage() {
		List<Item> items = InputView.getItems();
		ItemRepository.addItems(items);
	}

	private void processBuying() {
		int moneyToBuy = InputView.getMoneyToBuy();
		int remainingMoney = ItemRepository.buyItems(moneyToBuy);
		Map<Integer, Integer> changes = Coin.getChanges(remainingMoney);
		Coin.minusChangesFromMachineMoney(changes);
		for (Coin coin : Coin.values()) {
			System.out.println("coin = " + coin);
		}
		OutputView.printChanges(changes, remainingMoney);
	}
}
