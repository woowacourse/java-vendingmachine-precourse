package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinStore {
	private final EnumMap<Coin, Integer> coins = new EnumMap<Coin, Integer>(Coin.class) {
		{
			put(Coin.findCoin(500), 0);
			put(Coin.findCoin(100), 0);
			put(Coin.findCoin(50), 0);
			put(Coin.findCoin(10), 0);
		}
	};

	public CoinStore(int money) {
		createRandomCoins(money);
	}

	private void createRandomCoins(int money) {
		while (Coin.checkIsAtLeastCoin(money)) {
			int randomCoin = findRandomCoin();
			if (randomCoin <= money) {
				money -= randomCoin;
				plusCoin(randomCoin);
			}
		}
	}

	private void plusCoin(int money) {
		Coin findCoin = Coin.findCoin(money);
		coins.put(findCoin, coins.get(findCoin) + PLUS_COIN_ELEMENT);
	}

	private int findRandomCoin() {
		return Randoms.pickNumberInList(Coin.findCoinListByInteger());
	}
}
