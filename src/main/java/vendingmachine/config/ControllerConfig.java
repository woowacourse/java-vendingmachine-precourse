package vendingmachine.config;

import vendingmachine.controller.ChangeBackController;
import vendingmachine.controller.ChangeSafeController;
import vendingmachine.controller.DepositController;
import vendingmachine.controller.ProductController;
import vendingmachine.controller.PurchaseController;

public class ControllerConfig {

	public static ChangeSafeController getChangeSafeController() {
		return new ChangeSafeController(
			ServiceConfig.getMoneyService(),
			ServiceConfig.getChangeSafeService()
		);
	}

	public static ProductController getProductController() {
		return new ProductController(
			ServiceConfig.getSplitService(),
			ServiceConfig.getProductService()
		);
	}

	public static DepositController getDepositController() {
		return new DepositController(
			ServiceConfig.getMoneyService(),
			ServiceConfig.getDepositService()
		);
	}

	public static PurchaseController getPurchaseController() {
		return new PurchaseController(
			ServiceConfig.getPurchaseService(),
			ServiceConfig.getDepositService()
		);
	}

	public static ChangeBackController getChangeBackController() {
		return new ChangeBackController(
			ServiceConfig.getDepositService(),
			ServiceConfig.getChangeSafeService()
		);
	}
}
