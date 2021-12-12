package vendingmachine;

import java.util.Map;

public class CoreController {
	private CoinController coinController;
	private UiController uiController;

	CoreController() {
		coinController = new CoinController();
		uiController = new UiController();
	}

	protected void setVendingMachineHoldMoney() {
		int money = uiController.askVendingMachineHoldMoneyAmount();
		Map<Coin, Integer> numberOfCoins = coinController.makeRandomCombinationCoin(money);
		uiController.printCurrentCoinNumber(numberOfCoins);
	}
}
