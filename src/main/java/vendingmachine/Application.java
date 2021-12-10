package vendingmachine;

import vendingmachine.controller.CoinsController;
import vendingmachine.controller.ItemsController;
import vendingmachine.controller.UserBalanceController;

public class Application {
	public static void main(String[] args) {
		CoinsController coinsController = new CoinsController();
		coinsController.generateCoins();
		coinsController.printGeneratedCoins();

		ItemsController itemsController = new ItemsController();
		itemsController.generateItems();

		UserBalanceController userBalanceController = new UserBalanceController();
		userBalanceController.generateUserBalance();
	}
}
