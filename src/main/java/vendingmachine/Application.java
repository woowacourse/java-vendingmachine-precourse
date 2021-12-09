package vendingmachine;

import vendingmachine.controller.CoinsController;

public class Application {
	public static void main(String[] args) {
		CoinsController coinsController = new CoinsController();
		coinsController.generateCoins();
	}
}
