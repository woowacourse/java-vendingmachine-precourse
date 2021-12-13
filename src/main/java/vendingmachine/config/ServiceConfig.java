package vendingmachine.config;

import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.CoinService;
import vendingmachine.service.MoneyService;
import vendingmachine.service.ProductService;
import vendingmachine.service.ProductSplitService;
import vendingmachine.service.RandomCoinService;
import vendingmachine.service.SplitService;

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

	public static SplitService getSplitService() {
		return new ProductSplitService();
	}

	public static ProductService getProductService() {
		return new ProductService(RepositoryConfig.getProductRepository());
	}
}
