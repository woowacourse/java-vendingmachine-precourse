package vendingmachine.controller;

import vendingmachine.service.CoinService;
import vendingmachine.service.InputService;
import vendingmachine.service.ItemService;
import vendingmachine.service.OutputService;

public class VendingMachineController {

	private final InputService inputService = new InputService();
	private final OutputService outputService = new OutputService();
	private final CoinService coinService = new CoinService();
	private final ItemService itemService = new ItemService();

	public void start() {
		int moneyOfVendingMachine = inputService.readMoneyOfVendingMachine();
		outputService.enter();

		coinService.register(moneyOfVendingMachine);

		outputService.printAllCoinCount();
		outputService.enter();

		inputService.readItems()
			.stream()
			.forEach(item -> itemService.register(item));
		outputService.enter();

		int moneyOfUser = inputService.readMoneyOfUser();

	}

	public static void main(String[] args) {
		VendingMachineController controller = new VendingMachineController();
		controller.start();
	}
}
