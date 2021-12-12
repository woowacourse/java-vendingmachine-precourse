package vendingmachine;

public class CoreController {
	private CoinController coinController;
	private UiController uiController;

	CoreController() {
		coinController = new CoinController();
		uiController = new UiController();
	}

	protected void setVendingMachineHoldMoney() {
		int money = uiController.askVendingMachineHoldMoneyAmount();
		coinController.makeRandomCombinationCoin(money);
	}
}
