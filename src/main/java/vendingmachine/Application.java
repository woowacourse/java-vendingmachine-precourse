package vendingmachine;

import vendingmachine.controller.CoinsController;
import vendingmachine.controller.ItemsController;

public class Application {
	public static void main(String[] args) {
		CoinsController coinsController = new CoinsController();
		coinsController.generateCoins();

		ItemsController itemsController = new ItemsController();
		itemsController.generateItems();
	}
}
