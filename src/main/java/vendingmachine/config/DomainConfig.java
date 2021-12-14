package vendingmachine.config;

import vendingmachine.domain.CoinGenerator;

public class DomainConfig {

	public static CoinGenerator getCoinGenerator() {
		return new CoinGenerator();
	}


}
