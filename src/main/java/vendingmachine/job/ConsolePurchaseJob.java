package vendingmachine.job;

import vendingmachine.controller.PurchaseController;
import vendingmachine.view.ViewManager;

public class ConsolePurchaseJob implements PurchaseJob {

	private final ViewManager viewManager;
	private final PurchaseController controller;

	public ConsolePurchaseJob(ViewManager viewManager, PurchaseController controller) {
		this.viewManager = viewManager;
		this.controller = controller;
	}

	@Override
	public void execute() {
		while (true) {
			showMoney();
			if (!isAvailable()) {
				break;
			}
			tryExecute();
		}
		finish();
	}

	private void showMoney() {
		viewManager.output(controller.retrieveDeposit());
	}

	private boolean isAvailable() {
		return controller.isAvailable();
	}

	private void tryExecute() {
		try {
			controller.purchase(viewManager.input());
		} catch (IllegalArgumentException e) {
			viewManager.error(e.getMessage());
			tryExecute();
		}
	}

	private void finish() {
		viewManager.output(controller.retrieveChangeSafe());
	}
}
