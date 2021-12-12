package vendingmachine;

import vendingmachine.controller.CoinController;

public class Application {
	public static void main(String[] args) {
		CoinController coinController = new CoinController();
		coinController.setVendingMachineCoinCounter();
	}
}
