package vendingmachine.config;

import vendingmachine.controller.ChangeSafeController;
import vendingmachine.controller.DepositController;
import vendingmachine.controller.ProductController;
import vendingmachine.controller.PurchaseController;

public class ControllerConfig {

	public static ChangeSafeController getChangeSafeController() {
		return new ChangeSafeController();
	}

	public static ProductController getProductController() {
		return new ProductController();
	}

	public static DepositController getDepositController() {
		return new DepositController();
	}

	public static PurchaseController getPurchaseController() {
		return new PurchaseController();
	}
}
