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
		coinService.register(inputService.readMoneyOfVendingMachine());

		outputService.printAllCoinCount();
		outputService.enter();

		inputService.readItems()
			.stream()
			.forEach(item -> itemService.register(item));
		outputService.enter();

		money = inputService.readMoneyOfUser();
		outputService.enter();

		Item item = inputService.readItemName(money);
		item.subtractStockQuantity();
		money = item.subtractMoneyAfterPurchase(money);
	}

	public static void main(String[] args) {
		VendingMachineController controller = new VendingMachineController();
		controller.start();
	}
}
