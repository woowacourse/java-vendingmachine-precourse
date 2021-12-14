package vendingmachine.controller;

import java.util.List;
import java.util.Map;

import vendingmachine.constant.SystemMessage;
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
		OutputView.printChanges(changes, remainingMoney);
		printItemAfterBuying();
		printMachineChangesAfterBuying();
	}

	private void printItemAfterBuying() {
		System.out.println("=== 자판기 재고 ===");
		List<Item> items = ItemRepository.get();
		for (Item item : items) {
			System.out.println("item = " + item);
		}
		SystemMessage.printEmptyLine();
	}

	private void printMachineChangesAfterBuying() {
		System.out.println("=== 자판기 잔돈 ===");
		for (Coin coin : Coin.values()) {
			System.out.println("coin = " + coin);
		}
		SystemMessage.printEmptyLine();
	}
}
