package vendingmachine;

import java.util.Map;

import coincase.CoinController;
import ui.UiController;

public class CoreController {
	private CoinController coinController;
	private UiController uiController;

	CoreController() {
		coinController = new CoinController();
		uiController = new UiController();
	}

	protected void setVendingMachineHoldMoney() {
		int money = 0;
		boolean endCondition = false;
		while (!endCondition) {
			money = uiController.askVendingMachineHoldMoneyAmount();
			try {
				endCondition = coinController.checkMoneyIsValid(money);
			} catch (IllegalArgumentException e) {
				uiController.printLogicalExceptionError(e.getMessage());
			}
		}
		Map<Coin, Integer> numberOfCoins = coinController.makeRandomCombinationCoin(money);
		uiController.printCurrentCoinNumber(numberOfCoins);
	}
}
