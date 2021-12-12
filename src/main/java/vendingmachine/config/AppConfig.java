package vendingmachine.config;

import vendingmachine.VendingMachine;

public class AppConfig {

	public static VendingMachine getVendingMachine() {
		return new VendingMachine(
			UserConfig.getAdministrator(),
			UserConfig.getCustomer()
		);
	}
}
