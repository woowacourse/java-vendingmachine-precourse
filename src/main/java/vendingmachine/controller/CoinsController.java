package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.view.Input;

public class CoinsController {
	public static Coins getCoins() {
		Coins coins = new Coins(Input.getMoneyInMachine());
		coins.makeRandomNumberOfCoins();
		return coins;
	}
}
