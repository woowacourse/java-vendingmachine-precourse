package vendingmachine.service;

import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.userbalance.UserBalance;
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

	public Coins getCurrentCoins() {
		return coinsRepository.getCoins();
	}

	public Coins getChange(UserBalance userBalance) {
		return coinsRepository.getCoins().getChange(userBalance);
	}
}
