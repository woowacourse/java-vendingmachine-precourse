package vendingmachine;

import vendingmachine.controller.CoinsController;
import vendingmachine.domain.coins.Coins;

public class Application {
	public static void main(String[] args) {
		CoinsController coinsController = new CoinsController();
		Coins coins = coinsController.generateCoins();

		System.out.println(coins);
	}
}
