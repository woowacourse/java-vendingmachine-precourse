package vendingmachine.controller;

import vendingmachine.domain.Item;
import vendingmachine.service.CoinService;
import vendingmachine.service.InputService;
import vendingmachine.service.ItemService;
import vendingmachine.service.OutputService;

public class VendingMachineController {

	private final InputService inputService = new InputService();
	private final OutputService outputService = new OutputService();
	private final CoinService coinService = new CoinService();
	private final ItemService itemService = new ItemService();

	private static int money;

	public void start() {
		fillCoinsOfVendingMachine();
		outputService.printAllCoinCount();
		registerItems();
		putMoney();
		purchase();
		outputService.printUserMoney(money);
		outputService.printChange(coinService.returnChange(money));
	}

	private void putMoney() {
		money = inputService.readMoneyOfUser();
		outputService.enter();
	}

	private void registerItems() {
		inputService.readItems().stream()
			.forEach(item -> itemService.register(item));
		outputService.enter();
	}

	private void fillCoinsOfVendingMachine() {
		coinService.register(inputService.readMoneyOfVendingMachine());
		outputService.enter();
	}

	private void purchase() {
		do {
			outputService.printUserMoney(money);

			Item item = inputService.readItemName(money);
			item.subtractStockQuantity();

			money = item.subtractMoneyAfterPurchase(money);
			outputService.enter();
		} while (itemService.haveAnyItemToBuy(money));
	}
}
