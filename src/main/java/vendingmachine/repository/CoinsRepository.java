package vendingmachine.repository;

import vendingmachine.domain.coins.Coins;

public class CoinsRepository {
	private static CoinsRepository coinsRepository = new CoinsRepository();
	private Coins coins = Coins.create();

	private CoinsRepository() {
	}

	public static CoinsRepository getInstance() {
		return coinsRepository;
	}

	public void setCoins(Coins coins) {
		this.coins = coins;
	}

}
