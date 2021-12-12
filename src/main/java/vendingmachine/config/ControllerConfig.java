package vendingmachine.config;

import vendingmachine.controller.ChangeSafeController;
import vendingmachine.controller.DepositController;
import vendingmachine.controller.ProductController;

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
}
