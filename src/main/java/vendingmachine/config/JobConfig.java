package vendingmachine.config;

import vendingmachine.job.ChangeSafeJob;
import vendingmachine.job.ConsoleChangeSafeJob;
import vendingmachine.job.ConsoleDepositJob;
import vendingmachine.job.ConsoleProductJob;
import vendingmachine.job.ConsolePurchaseJob;
import vendingmachine.job.DepositJob;
import vendingmachine.job.ProductJob;
import vendingmachine.job.PurchaseJob;

public class JobConfig {

	public static ChangeSafeJob getChangeSafeJob() {
		return new ConsoleChangeSafeJob(
			ViewManagerConfig.getChangeSafeViewManager(),
			ControllerConfig.getChangeSafeController()
		);
	}

	public static ProductJob getProductJob() {
		return new ConsoleProductJob(
			ViewManagerConfig.getProductViewManager(),
			ControllerConfig.getProductController()
		);
	}

	public static DepositJob getDepositJob() {
		return new ConsoleDepositJob(
			ViewManagerConfig.getDepositManager(),
			ControllerConfig.getDepositController()
		);
	}

	public static PurchaseJob getPurchaseJob() {
		return new ConsolePurchaseJob();
	}
}
