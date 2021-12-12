package vendingmachine;

public class CoreController {
	private UiController uiController;

	CoreController() {
		uiController = new UiController();
	}

	protected void setVendingMachineHoldMoney() {
		int money = uiController.askVendingMachineHoldMoneyAmount();
	}
}
