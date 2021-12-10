package vendingmachine;

import vendingmachine.controller.CoinsController;
import vendingmachine.controller.ItemsController;
import vendingmachine.controller.UserBalanceController;

public class Application {
	private static final CoinsController coinsController = new CoinsController();
	private static final ItemsController itemsController = new ItemsController();
	private static final UserBalanceController userBalanceController = new UserBalanceController();

	public static void main(String[] args) {
		init();
		purchaseRoutine();
		coinsController.printChange();
	}

	private static void init() {
		coinsController.generateCoins();
		coinsController.printGeneratedCoins();

		itemsController.generateItems();

		userBalanceController.generateUserBalance();
	}

	private static void purchaseRoutine() {
		while (itemsController.checkAvailableToPurchase()) {
			itemsController.buyItem();
		}
	}
}
