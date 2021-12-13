package vendingmachine.config;

import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.CoinService;
import vendingmachine.service.MoneyService;
import vendingmachine.service.RandomCoinService;

public class ServiceConfig {

	public static MoneyService getMoneyService() {
		return new MoneyService();
	}

	public static ChangeSafeService getChangeSafeService() {
		return new ChangeSafeService(RepositoryConfig.getChangeSafeRepository());
	}

	public static CoinService getCoinService() {
		return new RandomCoinService();
	}
}
