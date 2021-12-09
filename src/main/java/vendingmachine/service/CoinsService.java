package vendingmachine.service;

import vendingmachine.domain.coins.Coins;
import vendingmachine.repository.CoinsRepository;

public class CoinsService {
	private static CoinsService coinsService = new CoinsService();
	private final CoinsRepository coinsRepository = CoinsRepository.getInstance();

	private CoinsService() {
	}

	public static CoinsService getInstance() {
		return coinsService;
	}

	public void initCoins(Coins coins) {
		coinsRepository.setCoins(coins);
	}
}
