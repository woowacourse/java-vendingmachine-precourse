package vendingmachine.config;

import vendingmachine.domain.CoinGenerator;
import vendingmachine.domain.GreedyCoinGenerator;
import vendingmachine.domain.RandomCoinGenerator;

public class DomainConfig {
	public static CoinGenerator getRandomCoinGenerator() {
		return new RandomCoinGenerator();
	}

	public static CoinGenerator getGreedyCoinGenerator() {
		return new GreedyCoinGenerator();
	}
}
