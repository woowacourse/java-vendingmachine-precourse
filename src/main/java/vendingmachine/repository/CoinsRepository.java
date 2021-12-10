package vendingmachine.repository;

import vendingmachine.domain.coins.Coins;

// TODO: repository 클래스가 getter, setter 를 둘다 갖는게 최선의 방법인지 고민 필요
public class CoinsRepository {
	private static CoinsRepository coinsRepository = new CoinsRepository();
	private Coins coins;

	private CoinsRepository() {
	}

	public static CoinsRepository getInstance() {
		return coinsRepository;
	}

	public Coins getCoins() {
		return this.coins;
	}

	public void setCoins(Coins coins) {
		this.coins = coins;
	}

}
