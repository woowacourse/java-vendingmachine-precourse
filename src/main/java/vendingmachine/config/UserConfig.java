package vendingmachine.config;

import vendingmachine.user.Administrator;
import vendingmachine.user.Customer;
import vendingmachine.user.VendingMachineAdministrator;
import vendingmachine.user.VendingMachineCustomer;

public class UserConfig {

	public static Administrator getAdministrator() {
		return new VendingMachineAdministrator(
			JobConfig.getChangeSafeJob(),
			JobConfig.getProductJob()
			);
	}

	public static Customer getCustomer() {
		return new VendingMachineCustomer(
			JobConfig.getDepositJob(),
			JobConfig.getPurchaseJob(),
			JobConfig.getChangeBackJob()
		);
	}
}
