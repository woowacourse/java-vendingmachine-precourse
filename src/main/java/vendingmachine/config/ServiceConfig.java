package vendingmachine.config;

import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.MoneyService;

public class ServiceConfig {

	public static MoneyService getMoneyService() {
		return new MoneyService();
	}

}
